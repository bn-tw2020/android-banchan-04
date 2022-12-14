package com.woowa.banchan.ui

import android.content.Intent
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.woowa.banchan.R
import com.woowa.banchan.ui.customview.LoadingFragment
import com.woowa.banchan.ui.navigator.OnBackClickListener
import com.woowa.banchan.ui.network.ConnectivityObserver
import com.woowa.banchan.ui.network.NetworkConnectivityObserver
import com.woowa.banchan.ui.screen.orderdetail.OrderDetailFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnBackClickListener {

    private lateinit var connectivityObserver: ConnectivityObserver
    private var dialog = LoadingFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectivityObserver = NetworkConnectivityObserver(applicationContext)
        setContentView(R.layout.activity_main)

        initDialog()
        observeNetwork()
        onNewIntent(intent)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        initDialog()
        observeNetwork()
    }

    private fun initDialog() {
        supportFragmentManager.executePendingTransactions()

        if (dialog.isAdded) {
            dialog.dismiss()
            dialog.show(supportFragmentManager, DIALOG_TAG)
            Toast.makeText(
                applicationContext,
                getString(R.string.message_network),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun observeNetwork() {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkNetwork(connectivityManager.activeNetwork != null)
        } else {
            checkNetwork(connectivityManager.isDefaultNetworkActive)
        }
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                connectivityObserver.observe().collect {
                    checkNetwork(it == ConnectivityObserver.Status.Available)
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        this.intent = intent
        val orderId = intent?.getLongExtra(getString(R.string.order_id), 0) ?: 0
        if (orderId == 0L) return
        else {
            supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in,
                    R.anim.slide_out,
                    R.anim.slide_in,
                    R.anim.slide_out
                )
                .addToBackStack(null)
                .add(R.id.fcv_main, OrderDetailFragment.newInstance(orderId))
                .commit()
        }
    }

    private fun checkNetwork(isActiveNetwork: Boolean) {
        supportFragmentManager.executePendingTransactions()

        if (isActiveNetwork) {
            if (dialog.isAdded) dialog.dismiss()
        } else {
            if (!dialog.isAdded) {
                dialog.show(supportFragmentManager, DIALOG_TAG)
                Toast.makeText(
                    applicationContext,
                    getString(R.string.message_network),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun getNetworkFlow() = connectivityObserver.observe()

    override fun navigateToBack() {
        onBackPressed()
    }

    companion object {
        private const val DIALOG_TAG = "LOADING"
    }
}

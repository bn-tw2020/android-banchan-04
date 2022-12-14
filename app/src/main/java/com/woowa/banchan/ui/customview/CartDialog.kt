package com.woowa.banchan.ui.customview

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.woowa.banchan.R
import com.woowa.banchan.databinding.FragmentDialogBinding
import com.woowa.banchan.ui.extensions.currentWindowMetricsPointCompat
import com.woowa.banchan.ui.navigator.OnCartClickListener
import com.woowa.banchan.ui.screen.cart.CartFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartDialog : DialogFragment(), OnCartClickListener {

    private var _binding: FragmentDialogBinding? = null
    private val binding: FragmentDialogBinding get() = requireNotNull(_binding)

    override fun onResume() {
        super.onResume()
        setDialogSize()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setDialogSize()
    }

    private fun setDialogSize() {
        val params: ViewGroup.LayoutParams? = dialog?.window?.attributes
        val windowManager =
            requireActivity().getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val size = windowManager.currentWindowMetricsPointCompat()
        val deviceWidth = size.x
        params?.width = (deviceWidth * 0.9).toInt()
        dialog?.window?.attributes = params as WindowManager.LayoutParams
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.btnCart.setOnClickListener { navigateToCart() }
        binding.btnStay.setOnClickListener { stay() }
    }

    fun stay() {
        dismiss()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun navigateToCart() {
        dismiss()
        requireActivity().supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in,
                R.anim.slide_out,
                R.anim.slide_in,
                R.anim.slide_out
            )
            .addToBackStack("main")
            .add(R.id.fcv_main, CartFragment())
            .commit()
    }
}

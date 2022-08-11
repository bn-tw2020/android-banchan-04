package com.woowa.banchan.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.woowa.banchan.R
import com.woowa.banchan.databinding.FragmentMainBinding
import com.woowa.banchan.ui.detail.DetailFragment
import com.woowa.banchan.ui.tabs.ViewPagerAdapter
import com.woowa.banchan.ui.tabs.common.OnClickMenu
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(), OnClickMenu {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        with(binding) {
            vpOrdering.adapter =
                ViewPagerAdapter(childFragmentManager, lifecycle, this@MainFragment)
            TabLayoutMediator(tlOrdering, vpOrdering) { tab, position ->
                tab.text = Tab.find(position)
            }.attach()
        }
    }

    override fun navigateToDetail() {
        parentFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fcv_main, DetailFragment())
            .commit()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
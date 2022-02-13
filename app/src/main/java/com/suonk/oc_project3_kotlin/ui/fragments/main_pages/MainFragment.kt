package com.suonk.oc_project3_kotlin.ui.fragments.main_pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.suonk.oc_project3_kotlin.R
import com.suonk.oc_project3_kotlin.databinding.FragmentMainBinding
import com.suonk.oc_project3_kotlin.ui.adapters.ViewPagerAdapter
import com.suonk.oc_project3_kotlin.ui.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

class MainFragment : BaseFragment() {

    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        binding?.viewPager?.adapter = ViewPagerAdapter(cxt)

        binding?.tabLayout?.let {
            binding?.viewPager?.let { it1 ->
                TabLayoutMediator(
                    it,
                    it1
                ) { tab, position ->
                    when (position) {
                        0 -> {
                            tab.text = getString(R.string.tab_neighbour_title)
                        }
                        1 -> {
                            tab.text = getString(R.string.tab_favorites_title)
                        }
                    }
                }.attach()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
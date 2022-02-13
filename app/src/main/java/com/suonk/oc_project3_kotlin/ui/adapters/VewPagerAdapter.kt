package com.suonk.oc_project3_kotlin.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.suonk.oc_project3_kotlin.ui.fragments.main_pages.NeighbourListFragment

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return NeighbourListFragment.newInstance(position == 0)
    }
}
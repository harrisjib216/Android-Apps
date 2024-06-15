package com.harrisjib216.snapchatclone

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SlidingPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(index: Int): Fragment = when (index) {
        0 -> Messages()
        1 -> Camera()
        else -> Feed()
    }
}
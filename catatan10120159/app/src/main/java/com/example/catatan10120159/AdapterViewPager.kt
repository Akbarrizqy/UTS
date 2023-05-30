package com.example.catatan10120159

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
class AdapterViewPager(fragmentActivity: FragmentActivity, val arr : ArrayList<Fragment>) :
    FragmentStateAdapter(fragmentActivity){

    override fun getItemCount(): Int = arr.size

    override fun createFragment(position: Int): Fragment {
        return arr[position]
    }
}

//Nim  : 10120159
//Nama : Muhammad Rizqy Akbar
//Kelas: IF-4

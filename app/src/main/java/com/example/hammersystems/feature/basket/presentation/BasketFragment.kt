package com.example.hammersystems.feature.basket.presentation

import com.example.hammersystems.R
import com.example.hammersystems.library.coreui.base.BaseFragment

class BasketFragment : BaseFragment(R.layout.fragment_basket) {

    override fun onBackPressed(): Boolean {
        return false
    }
}
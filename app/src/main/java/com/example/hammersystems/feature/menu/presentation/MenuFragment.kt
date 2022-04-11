package com.example.hammersystems.feature.menu.presentation

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.hammersystems.R
import com.example.hammersystems.library.coreui.base.BaseFragment
import com.example.hammersystems.databinding.FragmentMenuBinding

class MenuFragment : BaseFragment(R.layout.fragment_menu) {

    private val binding by viewBinding<FragmentMenuBinding>()

    override fun onBackPressed(): Boolean {
        return false
    }
}
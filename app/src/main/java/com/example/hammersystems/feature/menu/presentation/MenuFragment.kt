package com.example.hammersystems.feature.menu.presentation

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.hammersystems.R
import com.example.hammersystems.databinding.FragmentMenuBinding
import com.example.hammersystems.feature.menu.presentation.model.MenuViewEvent
import com.example.hammersystems.feature.menu.presentation.model.MenuViewState
import com.example.hammersystems.library.coreui.base.BaseMviFragment

class MenuFragment : BaseMviFragment<MenuViewState, MenuViewEvent, MenuViewModel>(R.layout.fragment_menu) {

    private val binding by viewBinding<FragmentMenuBinding>()
    override val viewModel by viewModels<MenuViewModel>()

    override fun render(state: MenuViewState) {

    }

    override fun onBackPressed() = false
}
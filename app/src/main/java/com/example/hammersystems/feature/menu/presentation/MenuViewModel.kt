package com.example.hammersystems.feature.menu.presentation

import com.example.hammersystems.feature.menu.presentation.model.MenuViewEvent
import com.example.hammersystems.feature.menu.presentation.model.MenuViewState
import com.example.hammersystems.library.coreui.base.BaseViewModel

class MenuViewModel : BaseViewModel<MenuViewState, MenuViewEvent>(
    initialState = MenuViewState.retrieveDefaultState()
) {

    override fun observe(event: MenuViewEvent) {

    }
}
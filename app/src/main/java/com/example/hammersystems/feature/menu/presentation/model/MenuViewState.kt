package com.example.hammersystems.feature.menu.presentation.model

import com.example.hammersystems.library.coreui.base.BaseViewState

data class MenuViewState(
    val a: String
) : BaseViewState {

    companion object{

        fun retrieveDefaultState(): MenuViewState{
            return MenuViewState(
                a = ""
            )
        }
    }
}
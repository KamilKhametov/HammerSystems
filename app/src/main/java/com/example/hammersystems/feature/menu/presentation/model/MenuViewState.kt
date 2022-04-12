package com.example.hammersystems.feature.menu.presentation.model

import com.example.hammersystems.feature.menu.domain.model.CategoryEntity
import com.example.hammersystems.library.coreui.base.BaseViewState

data class MenuViewState(
    val categories: List<CategoryEntity>
) : BaseViewState {

    companion object{

        fun retrieveDefaultState(): MenuViewState{
            return MenuViewState(
                categories = emptyList()
            )
        }
    }
}
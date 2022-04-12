package com.example.hammersystems.feature.menu.presentation.model

import com.example.hammersystems.feature.menu.domain.model.CategoryEntity
import com.example.hammersystems.feature.menu.domain.model.ProductEntity
import com.example.hammersystems.library.coreui.base.BaseViewState

data class MenuViewState(
    val categories: List<CategoryEntity>,
    val products: List<ProductEntity>,
    val error: String
) : BaseViewState {

    companion object{

        fun retrieveDefaultState(): MenuViewState{
            return MenuViewState(
                categories = emptyList(),
                products = emptyList(),
                error = ""
            )
        }
    }
}
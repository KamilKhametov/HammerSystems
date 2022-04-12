package com.example.hammersystems.feature.menu.presentation

import com.example.hammersystems.feature.menu.domain.repository.MenuRepository
import com.example.hammersystems.feature.menu.presentation.model.MenuViewEvent
import com.example.hammersystems.feature.menu.presentation.model.MenuViewState
import com.example.hammersystems.library.coreui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val repository: MenuRepository
) : BaseViewModel<MenuViewState, MenuViewEvent>(
    initialState = MenuViewState.retrieveDefaultState()
) {

    init {
        getCategories()
    }

    private fun getCategories(){
        launchIOCoroutine{
            val categoriesList = repository.getCategories()

            updateStateFromIo {
                copy(categories = categoriesList)
            }
        }
    }

    override fun observe(event: MenuViewEvent) {

    }
}
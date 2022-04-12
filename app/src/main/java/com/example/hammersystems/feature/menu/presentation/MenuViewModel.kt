package com.example.hammersystems.feature.menu.presentation

import com.example.hammersystems.feature.menu.domain.repository.MenuRepository
import com.example.hammersystems.feature.menu.presentation.model.MenuViewEvent
import com.example.hammersystems.feature.menu.presentation.model.MenuViewState
import com.example.hammersystems.library.coreimpl.locale.SharedPreferencesStorage
import com.example.hammersystems.library.coreui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val repository: MenuRepository,
    private val sPref: SharedPreferencesStorage
) : BaseViewModel<MenuViewState, MenuViewEvent>(
    initialState = MenuViewState.retrieveDefaultState()
) {

    init {
        getCategories()
        getProducts()
    }

    private fun getCategories(){
        launchIOCoroutine{
            try {
                val categoriesList = repository.getCategories()

                updateStateFromIo {
                    copy(categories = categoriesList)
                }

                sPref.lastCategories = categoriesList
            }catch (e: Exception){
                updateStateFromIo {
                    copy(
                        categories = sPref.lastCategories,
                        error = "Нет подключения к интернету"
                    )
                }
            }
        }
    }

    private fun getProducts(){
        launchIOCoroutine{
            try {
                val productsList = repository.getProducts()

                updateStateFromIo {
                    copy(products = productsList)
                }

                sPref.lastProducts = productsList
            }catch (e: Exception){
                updateStateFromIo {
                    copy(
                        products = sPref.lastProducts,
                        error = "Нет подключения к интернету"
                    )
                }
            }
        }
    }

    override fun observe(event: MenuViewEvent) {

    }
}
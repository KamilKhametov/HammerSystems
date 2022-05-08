package com.example.hammersystems.feature.menu.presentation

import com.example.hammersystems.feature.menu.domain.repository.MenuRepository
import com.example.hammersystems.feature.menu.presentation.model.MenuViewEvent
import com.example.hammersystems.feature.menu.presentation.model.MenuViewState
import com.example.hammersystems.library.coreimpl.database.ProductsDao
import com.example.hammersystems.library.coreui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val repository: MenuRepository,
    private val productsDao: ProductsDao
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

                productsDao.insertCategories(categoriesList)
            }catch (e: Exception){
                val localCategories = productsDao.getCategories()

                updateStateFromIo {
                    copy(
                        categories = localCategories,
                        error = "Нет подключения к интернету. Загружены локальные данные"
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

                productsDao.insertProducts(productsList)
            }catch (e: Exception){
                val localProducts = productsDao.getProducts()

                updateStateFromIo {
                    copy(
                        products = localProducts,
                        error = "Нет подключения к интернету. Загружены локальные данные"
                    )
                }
            }
        }
    }

    override fun observe(event: MenuViewEvent) {}
}
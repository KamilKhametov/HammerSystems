package com.example.hammersystems.feature.menu.presentation

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.PagerSnapHelper
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.hammersystems.R
import com.example.hammersystems.databinding.FragmentMenuBinding
import com.example.hammersystems.feature.menu.domain.model.CategoryEntity
import com.example.hammersystems.feature.menu.domain.model.ProductEntity
import com.example.hammersystems.feature.menu.presentation.adapters.BannersAdapter
import com.example.hammersystems.feature.menu.presentation.adapters.CategoriesAdapter
import com.example.hammersystems.feature.menu.presentation.adapters.ProductsAdapter
import com.example.hammersystems.feature.menu.presentation.model.MenuViewEvent
import com.example.hammersystems.feature.menu.presentation.model.MenuViewState
import com.example.hammersystems.library.coreui.base.BaseMviFragment
import com.example.hammersystems.library.coreui.global.extensions.uiLazy

class MenuFragment : BaseMviFragment<MenuViewState, MenuViewEvent, MenuViewModel>(R.layout.fragment_menu) {

    private val binding by viewBinding<FragmentMenuBinding>()
    override val viewModel by viewModels<MenuViewModel>()

    private val bannersAdapter by uiLazy {
        BannersAdapter()
    }

    private val categoriesAdapter by uiLazy {
        CategoriesAdapter()
    }

    private val productsAdapter by uiLazy {
        ProductsAdapter()
    }

    override fun setupUi() {

        initBannersAdapter()
        initCategoriesAdapter()
        initProductsAdapter()
    }

    override fun render(state: MenuViewState) {

    }

    private fun initBannersAdapter(){
        val bannersList = arrayListOf<Int>(R.drawable.banner, R.drawable.banner)
        with(binding.recyclerViewBanners){
            PagerSnapHelper().attachToRecyclerView(this)
            bannersAdapter.setBanners(bannersList)
            adapter = bannersAdapter
        }
    }

    private fun initCategoriesAdapter(){
        val categoriesList = arrayListOf<CategoryEntity>(
            CategoryEntity(
                "1",
                "Пицца"
            ),
            CategoryEntity(
                "2",
                "Комбо"
            ),
            CategoryEntity(
                "3",
                "Десерты"
            ),
            CategoryEntity(
                "4",
                "Напитки"
            )
        )
        with(binding.recyclerViewCategories){
            categoriesAdapter.setCategories(categoriesList)
            adapter = categoriesAdapter
        }
    }

    private fun initProductsAdapter(){
        val productsList = arrayListOf<ProductEntity>(
            ProductEntity(
                id = "1",
                imageUrl = "",
                name = "Ветчина и грибы",
                description = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                quantity = 345
            ),
            ProductEntity(
                id = "2",
                imageUrl = "",
                name = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                quantity = 345
            ),
            ProductEntity(
                id = "2",
                imageUrl = "",
                name = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                quantity = 345
            ),
            ProductEntity(
                id = "2",
                imageUrl = "",
                name = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                quantity = 345
            ),
            ProductEntity(
                id = "2",
                imageUrl = "",
                name = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                quantity = 345
            ),
            ProductEntity(
                id = "2",
                imageUrl = "",
                name = "Баварские колбаски",
                description = "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                quantity = 345
            )
        )
        with(binding.recyclerViewProducts){
            productsAdapter.setProducts(productsList)
            adapter = productsAdapter
        }
    }

    override fun onBackPressed() = false
}
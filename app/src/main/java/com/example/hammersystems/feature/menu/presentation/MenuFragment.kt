package com.example.hammersystems.feature.menu.presentation

import android.os.Handler
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
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
import com.example.hammersystems.library.coreui.global.extensions.toast
import com.example.hammersystems.library.coreui.global.extensions.uiLazy
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MenuFragment : BaseMviFragment<MenuViewState, MenuViewEvent, MenuViewModel>(R.layout.fragment_menu) {

    private val binding by viewBinding<FragmentMenuBinding>()
    override val viewModel by viewModels<MenuViewModel>()

    private val bannersAdapter by uiLazy {
        BannersAdapter()
    }

    private val categoriesAdapter by uiLazy {
        CategoriesAdapter {
            onCategoryClick(it)
        }
    }

    private val productsAdapter by uiLazy {
        ProductsAdapter()
    }

    private var swipeTimer: Timer? = null

    override fun setupUi() {

        initBannersAdapter()
        initCategoriesAdapter()
        initProductsAdapter()
        setTimerForBanners()
    }

    override fun render(state: MenuViewState) {

        setCategories(categoriesList = state.categories)
        setProducts(productsList = state.products)
        renderError(error = state.error)
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
        binding.recyclerViewCategories.adapter = categoriesAdapter
    }

    private fun setCategories(categoriesList: List<CategoryEntity>){
        categoriesAdapter.setCategories(categoriesList)
    }

    private fun initProductsAdapter(){
        binding.recyclerViewProducts.adapter = productsAdapter
    }

    private fun setProducts(productsList: List<ProductEntity>){
        productsAdapter.setProducts(productsList.toList())
    }

    private fun renderError(error: String){
        toast(error)
    }

    private fun onCategoryClick(position: Int) {
        with(binding) {
            val centerOfScreen = recyclerViewCategories.width / 3
            (recyclerViewCategories.layoutManager as? LinearLayoutManager)?.scrollToPositionWithOffset(
                position,
                centerOfScreen
            )
        }
    }

    private fun setTimerForBanners() {

        with(binding.recyclerViewBanners) {
            val sliderHandler = Handler()
            val sliderRunnable = Runnable {
                val position =
                    (layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
                if (position + 1 >= bannersAdapter.itemCount) {
                    smoothScrollToPosition(0)
                } else {
                    smoothScrollToPosition(position + 1)
                }
            }

            swipeTimer = Timer()
            swipeTimer?.schedule(object : TimerTask() {
                override fun run() {
                    sliderHandler.post(sliderRunnable)
                }
            }, IMAGE_SLIDE_DELAY, IMAGE_SLIDE_PERIOD)
        }
    }

    override fun onBackPressed() = false

    private companion object{

        private const val IMAGE_SLIDE_DELAY = 0L
        private const val IMAGE_SLIDE_PERIOD = 3000L
    }
}
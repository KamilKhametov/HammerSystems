package com.example.hammersystems.feature.menu.data.repo

import com.example.hammersystems.feature.menu.data.model.CategoryResponseDto
import com.example.hammersystems.feature.menu.data.model.ProductResponseDto
import com.example.hammersystems.feature.menu.data.network.MenuApi
import com.example.hammersystems.feature.menu.domain.model.CategoryEntity
import com.example.hammersystems.feature.menu.domain.model.ProductEntity
import com.example.hammersystems.feature.menu.domain.repository.MenuRepository
import com.example.hammersystems.library.coreui.base.BaseMapper
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val api: MenuApi,
    private val categoryMapper: BaseMapper<List<CategoryResponseDto>, List<CategoryEntity>>,
    private val productsMapper: BaseMapper<List<ProductResponseDto>, List<ProductEntity>>
) : MenuRepository {

    override suspend fun getCategories(): List<CategoryEntity> {
        return categoryMapper.map(from = api.getCategories())
    }

    override suspend fun getProducts(): List<ProductEntity> {
        return productsMapper.map(from = api.getProducts())
    }
}
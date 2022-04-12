package com.example.hammersystems.feature.menu.domain.repository

import com.example.hammersystems.feature.menu.domain.model.CategoryEntity
import com.example.hammersystems.feature.menu.domain.model.ProductEntity

interface MenuRepository {

    suspend fun getCategories(): List<CategoryEntity>
    suspend fun getProducts(): List<ProductEntity>
}
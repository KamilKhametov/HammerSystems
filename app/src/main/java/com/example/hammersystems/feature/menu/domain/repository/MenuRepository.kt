package com.example.hammersystems.feature.menu.domain.repository

import com.example.hammersystems.feature.menu.domain.model.CategoryEntity

interface MenuRepository {

    suspend fun getCategories(): List<CategoryEntity>
}
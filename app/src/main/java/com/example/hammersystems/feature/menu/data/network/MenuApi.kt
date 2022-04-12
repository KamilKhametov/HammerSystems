package com.example.hammersystems.feature.menu.data.network

import com.example.hammersystems.feature.menu.data.model.CategoryResponseDto
import com.example.hammersystems.feature.menu.data.model.ProductResponseDto
import retrofit2.http.GET

interface MenuApi {

    /**
     * Метод, для получения списка категорий
     */

    @GET("fakeApi.json")
    suspend fun getCategories(): List<CategoryResponseDto>

    /**
     * Метод, для получения списка блюд
     */

    @GET("showFakeApiProducts")
    suspend fun getProducts(): List<ProductResponseDto>
}
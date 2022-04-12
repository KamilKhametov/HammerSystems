package com.example.hammersystems.feature.menu.data.network

import com.example.hammersystems.feature.menu.data.model.CategoryResponseDto
import retrofit2.http.GET

interface MenuApi {

    /**
     * Метод, для получения списка категорий
     */

    @GET("fakeApi.json")
    suspend fun getCategories(): List<CategoryResponseDto>
}
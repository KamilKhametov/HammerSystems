package com.example.hammersystems.library.coreimpl.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hammersystems.feature.menu.domain.model.CategoryEntity
import com.example.hammersystems.feature.menu.domain.model.ProductEntity

@Dao
interface ProductsDao {

    @Insert
    fun insertProducts(products: List<ProductEntity>)

    @Insert
    fun insertCategories(categories: List<CategoryEntity>)

    @Query("SELECT * FROM products")
    fun getProducts(): List<ProductEntity>

    @Query("SELECT * FROM categories")
    fun getCategories(): List<CategoryEntity>
}
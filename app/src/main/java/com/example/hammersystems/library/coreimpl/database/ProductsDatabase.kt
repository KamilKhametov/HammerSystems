package com.example.hammersystems.library.coreimpl.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hammersystems.feature.menu.domain.model.CategoryEntity
import com.example.hammersystems.feature.menu.domain.model.ProductEntity

@Database(
    entities = [ProductEntity::class, CategoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ProductsDatabase : RoomDatabase(){
    abstract fun getProductsDao(): ProductsDao
}
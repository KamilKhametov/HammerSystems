package com.example.hammersystems.library.coreimpl.di.database

import android.content.Context
import androidx.room.Room
import com.example.hammersystems.library.coreimpl.database.ProductsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideProductsDatabase(@ApplicationContext applicationContext: Context) =
        Room.databaseBuilder(
            applicationContext,
            ProductsDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideProductsDao(productsDatabase: ProductsDatabase) =
        productsDatabase.getProductsDao()

    companion object {

        private const val DATABASE_NAME = "PRODUCTS"
    }
}
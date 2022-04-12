package com.example.hammersystems.feature.menu.data.di

import com.example.hammersystems.feature.menu.data.mapper.CategoryMapper
import com.example.hammersystems.feature.menu.data.mapper.ProductsMapper
import com.example.hammersystems.feature.menu.data.model.CategoryResponseDto
import com.example.hammersystems.feature.menu.data.model.ProductResponseDto
import com.example.hammersystems.feature.menu.data.network.MenuApi
import com.example.hammersystems.feature.menu.data.repo.MenuRepositoryImpl
import com.example.hammersystems.feature.menu.domain.model.CategoryEntity
import com.example.hammersystems.feature.menu.domain.model.ProductEntity
import com.example.hammersystems.feature.menu.domain.repository.MenuRepository
import com.example.hammersystems.library.coreui.base.BaseMapper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MenuModule {

    @Binds
    @Reusable
    abstract fun bindMenuRepository(impl: MenuRepositoryImpl): MenuRepository

    companion object{

        @Provides
        @Reusable
        fun provideCategoryMapper(impl: CategoryMapper): BaseMapper<List<CategoryResponseDto>, List<CategoryEntity>>{
            return impl
        }

        @Provides
        @Reusable
        fun provideProductsMapper(impl: ProductsMapper): BaseMapper<List<ProductResponseDto>, List<ProductEntity>> {
            return impl
        }

        @Provides
        @Singleton
        fun provideMenuApi(retrofit: Retrofit): MenuApi =
            retrofit.create(MenuApi::class.java)
    }
}
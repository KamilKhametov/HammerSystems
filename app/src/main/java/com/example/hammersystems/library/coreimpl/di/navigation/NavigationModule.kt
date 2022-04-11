package com.example.hammersystems.library.coreimpl.di.navigation

import com.example.hammersystems.library.coreimpl.navigation.LocaleCiceroneHolder
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NavigationModule {

    private val cicerone: Cicerone<Router> = Cicerone.create(Router())

    @Provides
    @Singleton
    fun provideAppRouter() = cicerone.router

    @Provides
    @Singleton
    fun provideAppNavigatorHolder() = cicerone.getNavigatorHolder()

    @Provides
    @Singleton
    fun provideLocalNavigationHolder() : LocaleCiceroneHolder = LocaleCiceroneHolder()
}
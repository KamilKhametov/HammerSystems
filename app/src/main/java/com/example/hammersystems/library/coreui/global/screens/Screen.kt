package com.example.hammersystems.library.coreui.global.screens

import com.example.hammersystems.feature.basket.presentation.BasketFragment
import com.example.hammersystems.feature.mainflow.MainFlowFragment
import com.example.hammersystems.feature.menu.presentation.MenuFragment
import com.example.hammersystems.feature.profile.presentation.ProfileFragment
import com.example.hammersystems.feature.tabcontainer.TabContainerFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screen {

    fun MainFlowScreen() = FragmentScreen {
        MainFlowFragment()
    }

    fun TabScreen(name: String) = FragmentScreen {
        TabContainerFragment.newInstance(containerName = name)
    }

    fun MenuScreen() = FragmentScreen{
        MenuFragment()
    }

    fun ProfileScreen() = FragmentScreen{
        ProfileFragment()
    }

    fun BasketScreen() = FragmentScreen{
        BasketFragment()
    }
}
package com.example.hammersystems.library.coreimpl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.hammersystems.R
import com.example.hammersystems.library.coreui.base.BaseFragment
import com.example.hammersystems.library.coreui.global.enums.TransitionType
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen

class Navigator(
    fragmentActivity: FragmentActivity,
    fragmentManager: FragmentManager = fragmentActivity.supportFragmentManager,
    containerId: Int
): AppNavigator(
    activity = fragmentActivity,
    fragmentManager = fragmentManager,
    containerId = containerId
) {

    override fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {

        val transitionType = (nextFragment as BaseFragment).transitionType

        if (currentFragment == null
            || currentFragment == nextFragment
            || transitionType == TransitionType.NONE
        ) return

        if (transitionType == TransitionType.HORIZONTAL) {
            fragmentTransaction.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            )
        }

        if (transitionType == TransitionType.VERTICAL) {
            fragmentTransaction.setCustomAnimations(
                R.anim.slide_in_bottom,
                R.anim.slide_out_top,
                R.anim.slide_in_top,
                R.anim.slide_out_bottom
            )
        }
    }
}
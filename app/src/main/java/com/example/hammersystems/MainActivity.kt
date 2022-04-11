package com.example.hammersystems

import android.os.Bundle
import com.example.hammersystems.library.coreui.base.BaseActivity
import com.example.hammersystems.library.coreui.base.BaseFragment
import com.example.hammersystems.library.coreimpl.navigation.Navigator
import com.example.hammersystems.library.coreui.global.screens.Screen
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    private val navigator by lazy(LazyThreadSafetyMode.NONE) {
        Navigator(
            fragmentActivity = this,
            containerId = R.id.main_container
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            router.navigateTo(Screen.MainFlowScreen())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.fragments.find { it.isVisible }

        if (fragment != null &&
            fragment is BaseFragment &&
            fragment.onBackPressed()
        ) {
            return
        } else {
            router.exit()
        }
    }
}
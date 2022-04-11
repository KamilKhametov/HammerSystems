package com.example.hammersystems.library.coreui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.example.hammersystems.library.coreimpl.navigation.LocaleCiceroneHolder
import com.example.hammersystems.library.coreimpl.navigation.Navigator
import com.example.hammersystems.library.coreimpl.navigation.RouterProvider
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseContainerFragment(
    @LayoutRes layoutResId: Int
): BaseFragment(layoutResId), RouterProvider {

    @Inject
    lateinit var ciceroneHolder: LocaleCiceroneHolder

    private val cicerone: Cicerone<Router>
        get() = ciceroneHolder.getCicerone(containerTag = containerName)

    override val router: Router
        get() = cicerone.router

    private val navigator by lazy(LazyThreadSafetyMode.NONE) {
        Navigator(
            fragmentActivity = requireActivity() as BaseActivity,
            containerId = containerResId,
            fragmentManager = childFragmentManager
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (childFragmentManager.findFragmentById(containerResId) == null) {
            executeTransactions()
        }
    }

    override fun onResume() {
        super.onResume()
        cicerone.getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        cicerone.getNavigatorHolder().removeNavigator()
        super.onPause()
    }

    override fun switchNavigationTab(toPosition: Int) {
        childFragmentManager.findFragmentById(containerResId)?.let { fragment ->
            if (fragment is BaseFragment) {
                fragment.switchNavigationTab(toPosition)
            }
        }
    }

    override fun onBackPressed(): Boolean {
        val fragment = childFragmentManager.findFragmentById(containerResId)
        return (fragment != null && fragment is BaseFragment && fragment.onBackPressed())
    }

    abstract val containerResId: Int
    abstract val containerName: String

    abstract fun executeTransactions()

    fun resetStack() {
        router.backTo(null)
    }
}
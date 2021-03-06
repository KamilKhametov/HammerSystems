package com.example.hammersystems.feature.mainflow

import android.os.Bundle
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.hammersystems.R
import com.example.hammersystems.library.coreui.base.BaseFragment
import com.example.hammersystems.databinding.FragmentMainFlowBinding
import com.example.hammersystems.library.coreui.global.enums.FlowTab
import com.example.hammersystems.library.coreimpl.navigation.Navigator
import com.example.hammersystems.library.coreui.global.screens.Screen
import com.example.hammersystems.feature.tabcontainer.TabContainerFragment
import com.example.hammersystems.library.coreui.base.BaseMviFragment
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.hilt.android.AndroidEntryPoint
import com.example.hammersystems.feature.mainflow.model.MainFlowViewEvent
import com.example.hammersystems.feature.mainflow.model.MainFlowViewState
import javax.inject.Inject

@AndroidEntryPoint
class MainFlowFragment: BaseMviFragment<MainFlowViewState, MainFlowViewEvent, MainFlowViewModel>(R.layout.fragment_main_flow) {

    private val binding by viewBinding(FragmentMainFlowBinding::bind)
    override val viewModel by viewModels<MainFlowViewModel>()

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    private val navigator by lazy(LazyThreadSafetyMode.NONE) {
        Navigator(
            fragmentActivity = requireActivity(),
            fragmentManager = childFragmentManager,
            containerId = R.id.main
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            selectTab(FlowTab.MENU)
        }
    }

    override fun onResume() {
        navigationHolder.setNavigator(navigator)
        super.onResume()
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }

    override fun setupUi() {
        initBottomNavigation()
    }

    private fun initBottomNavigation() {

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val tab = FlowTab.getBy(itemId = item.itemId)
            selectTab(tab)
            true
        }
    }

    private fun selectTab(tab: FlowTab) {

        val currentFragment = childFragmentManager.fragments.find { it.isVisible }
        val newFragment = childFragmentManager.findFragmentByTag(tab.containerTag)

        if (currentFragment != null
            && currentFragment == newFragment
            && currentFragment is TabContainerFragment
        ) {
            currentFragment.resetStack()
            return
        }

        val transaction = childFragmentManager.beginTransaction()

        if (newFragment == null) {
            transaction.add(
                R.id.main,
                Screen.TabScreen(tab.containerTag).createFragment(childFragmentManager.fragmentFactory),
                tab.containerTag
            )
        }

        if (newFragment != null) {
            transaction.show(newFragment)
        }

        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }

        transaction.commitNow()
    }

    override fun render(state: MainFlowViewState) = Unit

    override fun onBackPressed(): Boolean {
        val fragment = childFragmentManager.fragments.find { it.isVisible }
        return fragment != null && fragment is BaseFragment && fragment.onBackPressed()
    }
}
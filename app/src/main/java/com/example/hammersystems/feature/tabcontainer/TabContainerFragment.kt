package com.example.hammersystems.feature.tabcontainer

import com.example.hammersystems.R
import com.example.hammersystems.library.coreui.base.BaseContainerFragment
import com.example.hammersystems.library.coreui.global.enums.FlowTab
import com.example.hammersystems.library.coreui.global.extensions.withArgs
import com.example.hammersystems.library.coreui.global.screens.Screen

class TabContainerFragment : BaseContainerFragment(R.layout.fragment_primary) {

    override val containerName: String
        get() = requireArguments().getString(ARG_CONTAINER_NAME).orEmpty()

    override val containerResId: Int
        get() = R.id.primary_tab_container

    override fun executeTransactions() {

        val screen = when (containerName) {
            FlowTab.MENU.containerTag      -> Screen.MenuScreen()
            FlowTab.PROFILE.containerTag   -> Screen.ProfileScreen()
            FlowTab.BASKET.containerTag    -> Screen.BasketScreen()
            else                       -> throw IllegalStateException("There is no such tab container")
        }
        router.replaceScreen(screen)
    }

    companion object {

        private const val ARG_CONTAINER_NAME = "ARG_CONTAINER_NAME"

        fun newInstance(containerName: String) = TabContainerFragment().withArgs {
            putString(ARG_CONTAINER_NAME, containerName)
        }
    }
}
package com.example.hammersystems.library.coreui.global.enums

import com.example.hammersystems.R


enum class FlowTab(val itemId: Int, val position: Int, val containerTag: String) {
    MENU(
        itemId = R.id.action_menu,
        position = 0,
        containerTag = "MENU_TAB_CONTAINER"
    ),
    PROFILE(
        itemId = R.id.action_profile,
        position = 1,
        containerTag = "PROFILE_TAB_CONTAINER"
    ),
    BASKET(
        itemId = R.id.action_basket,
        position = 2,
        containerTag = "BASKET_TAB_CONTAINER"
    );

    companion object {
        fun getBy(itemId: Int): FlowTab {
            return values().first { itemId == it.itemId }
        }
    }
}
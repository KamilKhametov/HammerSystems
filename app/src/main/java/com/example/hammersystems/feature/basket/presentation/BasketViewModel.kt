package com.example.hammersystems.feature.basket.presentation

import com.example.hammersystems.feature.basket.presentation.model.BasketViewEvent
import com.example.hammersystems.feature.basket.presentation.model.BasketViewState
import com.example.hammersystems.library.coreui.base.BaseViewModel

class BasketViewModel : BaseViewModel<BasketViewState, BasketViewEvent>(
    initialState = BasketViewState()
) {

    override fun observe(event: BasketViewEvent) {

    }
}
package com.example.hammersystems.feature.mainflow

import com.example.hammersystems.library.coreui.base.BaseViewModel
import com.example.hammersystems.feature.mainflow.model.MainFlowViewEvent
import com.example.hammersystems.feature.mainflow.model.MainFlowViewState

class MainFlowViewModel : BaseViewModel<MainFlowViewState, MainFlowViewEvent>(
    initialState = MainFlowViewState()
) {

    override fun observe(event: MainFlowViewEvent) {

    }
}
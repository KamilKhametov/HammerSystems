package com.example.hammersystems.feature.profile.presentation

import com.example.hammersystems.feature.profile.presentation.model.ProfileViewEvent
import com.example.hammersystems.feature.profile.presentation.model.ProfileViewState
import com.example.hammersystems.library.coreui.base.BaseViewModel

class ProfileViewModel : BaseViewModel<ProfileViewState, ProfileViewEvent>(
    initialState = ProfileViewState()
) {

    override fun observe(event: ProfileViewEvent) {

    }
}
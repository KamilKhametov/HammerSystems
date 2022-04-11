package com.example.hammersystems.feature.profile.presentation

import androidx.fragment.app.viewModels
import com.example.hammersystems.R
import com.example.hammersystems.feature.profile.presentation.model.ProfileViewEvent
import com.example.hammersystems.feature.profile.presentation.model.ProfileViewState
import com.example.hammersystems.library.coreui.base.BaseMviFragment

class ProfileFragment : BaseMviFragment<ProfileViewState, ProfileViewEvent, ProfileViewModel>(R.layout.fragment_profile) {

    override val viewModel by viewModels<ProfileViewModel>()

    override fun render(state: ProfileViewState) {

    }

    override fun onBackPressed() = false
}
package com.example.hammersystems.feature.basket.presentation

import androidx.fragment.app.viewModels
import com.example.hammersystems.R
import com.example.hammersystems.feature.basket.presentation.model.BasketViewEvent
import com.example.hammersystems.feature.basket.presentation.model.BasketViewState
import com.example.hammersystems.library.coreui.base.BaseMviFragment

class BasketFragment : BaseMviFragment<BasketViewState, BasketViewEvent, BasketViewModel>(R.layout.fragment_basket) {

    override val viewModel by viewModels<BasketViewModel>()

    override fun render(state: BasketViewState) {

    }

    override fun onBackPressed() = false
}
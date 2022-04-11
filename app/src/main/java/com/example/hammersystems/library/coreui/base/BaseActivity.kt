package com.example.hammersystems.library.coreui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hammersystems.library.coreimpl.navigation.RouterProvider
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), RouterProvider {

    @Inject
    override lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
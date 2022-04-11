package com.example.hammersystems.library.coreui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.hammersystems.library.coreui.global.enums.TransitionType

abstract class BaseFragment(@LayoutRes layoutResId: Int) : Fragment(layoutResId){

    open val transitionType: TransitionType = TransitionType.HORIZONTAL

    open fun showNavigationMenu(show: Boolean) {
        (parentFragment as? BaseFragment)?.showNavigationMenu(show = show)
    }

    open fun switchNavigationTab(toPosition: Int) {
        (parentFragment as? BaseFragment)?.switchNavigationTab(toPosition = toPosition)
    }

    protected open fun setupUi() = Unit

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupUi()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isRealDestroy()) {
            onFinalDestroy()
        }
    }

    abstract fun onBackPressed(): Boolean

    open fun onFinalDestroy() = Unit

    private fun isRealDestroy(): Boolean =
        when {
            activity?.isChangingConfigurations == true -> false
            activity?.isFinishing == true -> true
            else -> isRealRemoving()
        }

    private fun isRealRemoving(): Boolean {
        return (isRemoving) ||
                ((parentFragment as? BaseFragment)?.isRealRemoving() ?: false)
    }
}
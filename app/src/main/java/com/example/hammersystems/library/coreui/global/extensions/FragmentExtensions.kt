package com.example.hammersystems.library.coreui.global.extensions

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment

inline fun <T : Fragment> T.withArgs(
    argsBuilder: Bundle.() -> Unit
): T =
    this.apply {
        arguments = Bundle().apply(argsBuilder)
    }

fun Fragment.toast(text: String){
    if (text.isNotBlank()) Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}
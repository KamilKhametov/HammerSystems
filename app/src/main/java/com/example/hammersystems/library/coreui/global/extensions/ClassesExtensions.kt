package com.example.hammersystems.library.coreui.global.extensions

fun <T> uiLazy(operation: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) {
    operation()
}
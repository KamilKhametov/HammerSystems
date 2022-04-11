package com.example.hammersystems.library.coreui.base

interface BaseMapper<FROM, TO> {
    fun map(from: FROM): TO
}
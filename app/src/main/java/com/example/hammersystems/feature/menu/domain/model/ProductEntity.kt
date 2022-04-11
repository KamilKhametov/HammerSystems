package com.example.hammersystems.feature.menu.domain.model

data class ProductEntity(
    val id: String,
    val imageUrl: String,
    val name: String,
    val description: String,
    val quantity: Int
)
package com.example.hammersystems.feature.menu.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponseDto(
    @SerialName("id") val id: String,
    @SerialName("imageUrl") val imageUrl: String,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("quantity") val quantity: Int
)
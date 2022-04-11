package com.example.hammersystems.feature.menu.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponseDto(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String
)
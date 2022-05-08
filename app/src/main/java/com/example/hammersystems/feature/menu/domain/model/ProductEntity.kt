package com.example.hammersystems.feature.menu.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey val id: String,
    val imageUrl: String,
    val name: String,
    val description: String,
    val quantity: Int
)
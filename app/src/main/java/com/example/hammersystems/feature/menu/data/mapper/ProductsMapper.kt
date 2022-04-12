package com.example.hammersystems.feature.menu.data.mapper

import com.example.hammersystems.feature.menu.data.model.ProductResponseDto
import com.example.hammersystems.feature.menu.domain.model.ProductEntity
import com.example.hammersystems.library.coreui.base.BaseMapper
import javax.inject.Inject

class ProductsMapper @Inject constructor(): BaseMapper<List<ProductResponseDto>, List<ProductEntity>> {

    override fun map(from: List<ProductResponseDto>): List<ProductEntity> {
        return from.map {
            ProductEntity(
                id = it.id,
                imageUrl = it.imageUrl,
                name = it.name,
                description = it.description,
                quantity = it.quantity
            )
        }
    }
}
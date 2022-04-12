package com.example.hammersystems.feature.menu.data.mapper

import com.example.hammersystems.feature.menu.data.model.CategoryResponseDto
import com.example.hammersystems.feature.menu.domain.model.CategoryEntity
import com.example.hammersystems.library.coreui.base.BaseMapper
import javax.inject.Inject

class CategoryMapper @Inject constructor() : BaseMapper<List<CategoryResponseDto>, List<CategoryEntity>> {

    override fun map(from: List<CategoryResponseDto>): List<CategoryEntity> {
        return from.map {
            CategoryEntity(
                id = it.id,
                name = it.name
            )
        }
    }
}
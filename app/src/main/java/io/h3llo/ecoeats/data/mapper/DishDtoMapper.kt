package io.h3llo.ecoeats.data.mapper

import io.h3llo.ecoeats.data.networking.model.DishDto
import io.h3llo.ecoeats.domain.model.Dish

class DishDtoMapper : EntityMapper<DishDto, Dish> {


    override fun mapToDomainModel(dto: DishDto): Dish {

        TODO("Not yet implemented")
    }

    override fun mapFromDomainModel(domainModel: Dish): DishDto {
        TODO("Not yet implemented")
    }
}
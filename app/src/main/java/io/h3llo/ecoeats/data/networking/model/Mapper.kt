package io.h3llo.ecoeats.data.networking.model

import io.h3llo.ecoeats.domain.model.Dish
import io.h3llo.ecoeats.domain.model.User

fun UserDto.toUser(): User {
    return User(
        id = id,
        email = email
    )
}

fun List<DishDto>.toDishList(): List<Dish> = map {
    Dish(
        id = it.id,
        name = it.name,
        description = it.description,
        thumbails = it.thumbails,
        image = it.image,
        carbohydrates = it.carbohydrates,
        proteins = it.proteins,
        price = it.price,
        rating = it.rating,
        ingredients = it.ingredients,
        flagHeader = it.flagHeader,
    )
}
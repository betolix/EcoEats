package io.h3llo.ecoeats.data.networking.model

import io.h3llo.ecoeats.domain.model.User

fun UserDto.toUser() : User{
    return User(
        id = id,
        email = email
    )
}
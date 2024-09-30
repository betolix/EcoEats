package io.h3llo.ecoeats.data.mapper

import io.h3llo.ecoeats.data.networking.model.UserDto
import io.h3llo.ecoeats.domain.model.User
import javax.inject.Inject

//class AuthDtoMapper : EntityMapper<UserDto, User> {
class AuthDtoMapper @Inject constructor() : EntityMapper<UserDto, User> {
    override fun mapToDomainModel(dto: UserDto): User {

        return User(
            id = dto.id,
            email = dto.email
        )
    }

    override fun mapFromDomainModel(domainModel: User): UserDto {
        TODO("Not yet implemented")
    }


}
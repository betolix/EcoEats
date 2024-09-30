package io.h3llo.ecoeats.data.mapper

interface EntityMapper<T, DomainModel> {

    fun mapToDomainModel(dto: T) : DomainModel

    fun mapFromDomainModel(domainModel: DomainModel) : T

}
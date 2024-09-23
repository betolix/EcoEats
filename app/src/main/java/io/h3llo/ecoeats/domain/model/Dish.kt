package io.h3llo.ecoeats.domain.model


data class Dish(
    val carbohydrates: Int,
    val description: String,
    val flagHeader: Boolean,
    val id: Int,
    val image: String,
    val ingredients: String,
    val name: String,
    val price: Int,
    val proteins: Int,
    val rating: Double,
    val thumbnails: String
)

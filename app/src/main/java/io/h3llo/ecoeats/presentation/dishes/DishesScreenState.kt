package io.h3llo.ecoeats.presentation.dishes

import io.h3llo.ecoeats.data.networking.model.DishDto

data class DishesScreenState(
    val isLoading:Boolean=false,
    val error:String?=null,
    var success:List<DishDto>?=null
)

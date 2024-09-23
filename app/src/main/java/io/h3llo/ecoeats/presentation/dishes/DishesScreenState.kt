package io.h3llo.ecoeats.presentation.dishes

import io.h3llo.ecoeats.domain.model.Dish

data class DishesScreenState(
    val isLoading:Boolean=false,
    val error:String?=null,
    var success:List<Dish>?=null
)

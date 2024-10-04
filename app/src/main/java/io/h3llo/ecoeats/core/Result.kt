package io.h3llo.ecoeats.core

import io.h3llo.ecoeats.data.networking.model.UserDto


sealed class Result<T>(val data:T?=null, val message:String?=null) {

    class Success<T>(data:T?) : Result<T>(data = data)
    class Error<T>(message:String?) : Result<T>(message = message)
    class Validation<T>(message:String?) : Result<T>(message = message)
    //class Loading<T> : Result<T>()

}
package io.h3llo.ecoeats.data.util

import android.content.SharedPreferences

object Util{

    fun saveTokenSharedPreferences(sharedPreferences: SharedPreferences, data: String) {
        val preferences = sharedPreferences.edit().putString("KEY_TOKEN", data).apply()
    }

    fun SharedPreferences.save( data: String) {
        val preferences = this.edit().putString("KEY_TOKEN", data).apply()
    }

}


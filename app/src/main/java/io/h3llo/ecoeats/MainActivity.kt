package io.h3llo.ecoeats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import io.h3llo.ecoeats.navigation.SetupNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()

        // val preferences = getSharedPreferences("PREFERENCES_TEST",0).edit()
        // preferences.putString("KEY", "123")
        // preferences.apply()

        setContent {

            SetupNavigation()
        }
    }
}


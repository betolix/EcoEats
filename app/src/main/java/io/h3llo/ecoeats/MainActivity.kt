package io.h3llo.ecoeats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.h3llo.ecoeats.data.networking.Api
import io.h3llo.ecoeats.data.networking.model.LoginRequest
import io.h3llo.ecoeats.navigation.SetupNavigation
import io.h3llo.ecoeats.ui.theme.EcoEatsTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Response

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


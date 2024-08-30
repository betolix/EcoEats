package io.h3llo.ecoeats.presentation.sign_in

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.h3llo.ecoeats.presentation.preview.PreviewDefault

@Composable
fun SignInScreen(modifier: Modifier = Modifier) {
    Text(text = "Sign In Screen")

}

@PreviewDefault
@Composable
private fun SignInScreenPreview() {
    SignInScreen()
}
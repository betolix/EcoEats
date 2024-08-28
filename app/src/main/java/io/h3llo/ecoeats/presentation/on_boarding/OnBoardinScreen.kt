package io.h3llo.ecoeats.presentation.on_boarding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.h3llo.ecoeats.presentation.common.TextBasic
import io.h3llo.ecoeats.presentation.preview.PreviewDefault

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {
    Text(text = "OnBoardingscreen")
    
}

@PreviewDefault
@Composable
private fun OnBoardingScreenPreview() {

    OnBoardingScreen()
}
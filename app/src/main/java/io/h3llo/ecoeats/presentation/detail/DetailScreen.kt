package io.h3llo.ecoeats.presentation.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.h3llo.ecoeats.domain.model.Dish

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    dish: Dish
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = dish.name)

    }
}

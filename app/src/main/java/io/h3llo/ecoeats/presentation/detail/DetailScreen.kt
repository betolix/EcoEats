package io.h3llo.ecoeats.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import io.h3llo.ecoeats.domain.model.Dish
import io.h3llo.ecoeats.presentation.common.RatingBarcomponent
import io.h3llo.ecoeats.presentation.common.TextBasic
import io.h3llo.ecoeats.presentation.on_boarding.OnBoardingScreen
import io.h3llo.ecoeats.presentation.preview.PreviewDefault
import io.h3llo.ecoeats.ui.theme.Secondary

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    dish: Dish,
    paddingValues: PaddingValues,
) {
    /*
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = dish.name )
    }
     */

    val context = LocalContext.current

    Column (
        modifier = modifier.fillMaxSize()
            .padding(paddingValues),//.background(Color.Green),


        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    )
    {
        //Text(text = dish.name )

        TextBasic(
            text = dish.name,
            style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 8.dp, bottom = 8.dp)
        )

        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(dish.image)
                .crossfade(500)
                .build(),
            contentDescription = "Dish",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentScale = ContentScale.Crop

        )
        Spacer(modifier = Modifier.height(12.dp))
        TextBasic(
            text = dish.name,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextBasic(
            text = "Carbohidratos",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        )
        Spacer(modifier = Modifier.height(2.dp))
        TextBasic(
            text = "${dish.carbohydrates.toString()}g.",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Secondary
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextBasic(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Secondary
            )
        )

        RatingBarcomponent(currentRating = dish.rating.toInt())

    }
}





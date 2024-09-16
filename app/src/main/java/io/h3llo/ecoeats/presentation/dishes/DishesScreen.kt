package io.h3llo.ecoeats.presentation.dishes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.h3llo.ecoeats.R
import io.h3llo.ecoeats.data.networking.model.DishDto
import io.h3llo.ecoeats.presentation.common.TextBasic
import io.h3llo.ecoeats.presentation.preview.PreviewWithoutBackground
import io.h3llo.ecoeats.ui.theme.Primary
import io.h3llo.ecoeats.ui.theme.Secondary

@Composable
fun DishesScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues
) {

    //Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    //    Text("Dishes Screen", modifier = Modifier.padding(paddingValues = paddingValues))
    //}

    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {


    }

}


@Composable
fun DishItem(
    modifier: Modifier = Modifier,
    dishDto: DishDto
) {

    Card (
        border = BorderStroke(
            width = 2.dp,
            color = Secondary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {  }
    ){
        // Text(text = "Hola")
        Column (
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.icon_dish_template),
                "Icon dish template",
                modifier = Modifier.fillMaxWidth().height(100.dp),
                contentScale = ContentScale.Crop
            )
            Spacer (modifier = Modifier.height (12.dp))
            TextBasic(
                text = "Ensalada César",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer (modifier = Modifier.height (8.dp))
            TextBasic(
                text = "Carbohidratos",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            Spacer (modifier = Modifier.height (2.dp))
            TextBasic(
                text = "279.20 Carbohidratos",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Secondary
                )
            )

        }
    }
}

@PreviewWithoutBackground
@Composable
private fun DishItemPreview(modifier: Modifier = Modifier ) {
    DishItem(dishDto = DishDto(
        100,
        "Dish description",
        true,
        1,
        "image",
        "ingredients",
        "name",
        7,
        7,
        2.5,
        "thumbnails"
    ))
}
package io.h3llo.ecoeats.presentation.dishes

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import io.h3llo.ecoeats.domain.model.Dish
import io.h3llo.ecoeats.presentation.common.RatingBarcomponent
import io.h3llo.ecoeats.presentation.common.TextBasic
import io.h3llo.ecoeats.ui.theme.Secondary

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DishesScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    viewModel: DishesViewModel = hiltViewModel(),
    onClick: (Dish) -> Unit
) {

    val state = viewModel.state
    val context = LocalContext.current

    val pagerState = com.google.accompanist.pager.rememberPagerState()

    if (viewModel.state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.getDishes()
    }

    //Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    //    Text("Dishes Screen", modifier = Modifier.padding(paddingValues = paddingValues))
    //}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {

        TextBasic(
            text = "¿Que hay de nuevo?",
            style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 8.dp, bottom = 8.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            viewModel.state.success?.let { dishes ->
                val dishesFilter = dishes.filter {
                    it.flagHeader
                }
                HorizontalPager(
                    count = dishesFilter.count(),
                    state = pagerState
                ) { index ->
                    PagerDishComponent(
                        dish = dishesFilter[index],
                        context = context,
                        onClick = {
                            onClick(it)
                        }
                    )
                }
                Row(
                    modifier = Modifier.padding(8.dp)
                ) {
                    repeat(dishesFilter.size) { iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) Color.White else Color.Gray
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .clip(CircleShape)
                                .background(color)
                                .size(8.dp)
                        )

                    }
                }
            }
        }


        TextBasic(
            text = "Carta del dia",
            style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 8.dp, bottom = 8.dp)
        )



        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            viewModel.state.success?.let {
                items(it) {
                    DishItem(
                        dish = it,
                        context = context,
                        onClick = {
                            onClick(it)
                        }
                    )

                }
            }

        }
    }


}

@Composable
fun PagerDishComponent(
    modifier: Modifier = Modifier,
    dish: Dish,
    context: Context,
    onClick:(Dish)-> Unit
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .clickable {
            onClick(dish)
        }
    )
    {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(dish.image)
                .crossfade(500)
                .build(),
            contentDescription = dish.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
        ) {
            TextBasic(
                text = dish.name, style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextBasic(
                text = dish.description, style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )

        }
    }

}


@Composable
fun DishItem(
    modifier: Modifier = Modifier,
    dish: Dish,
    context: Context,
    onClick:(Dish)-> Unit
) {

    Card(
        border = BorderStroke(
            width = 2.dp,
            color = Secondary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick(dish)
            }
    ) {
        // Text(text = "Hola")
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            // Image(
            //    painter = painterResource(R.drawable.icon_dish_template),
            //    "Icon dish template",
            //    modifier = Modifier
            //        .fillMaxWidth()
            //        .height(100.dp),
            //    contentScale = ContentScale.Crop
            // )
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

            RatingBarcomponent(currentRating = dish.rating.toInt())

        }
    }
}

//@PreviewWithoutBackground
//@Composable
//private fun DishItemPreview(modifier: Modifier = Modifier) {
//    DishItem(
//        dishDto = DishDto(
//            100,
//            "Dish description",
//            true,
//            1,
//            "image",
//            "ingredients",
//            "name",
//            7,
//            7,
//            2.5,
//            "thumbnails"
//        )
//    )
//}
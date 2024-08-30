package io.h3llo.ecoeats.presentation.on_boarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import io.h3llo.ecoeats.presentation.preview.PreviewDefault
import io.h3llo.ecoeats.ui.theme.Primary
import io.h3llo.ecoeats.ui.theme.Secondary


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {

    val pagerState = rememberPagerState()

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),
                //.background(Color.Blue),
            count = 3,
            state = pagerState
        ) { page ->
            Text(text = "$page")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                //.background(Color.Magenta),
            horizontalArrangement = Arrangement.Center

        ) {
            onBoardingFooter(pagerState = pagerState)
        }

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun onBoardingFooter(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    repeat(3) {iteration ->
        val color = if(pagerState.currentPage == iteration ) Primary else Secondary
        Box(
            modifier = modifier
                .padding(2.dp)
                .clip(CircleShape)
                .background(color)
                .size(12.dp)
        )
    }

}

@PreviewDefault
@Composable
private fun OnBoardingScreenPreview() {

    OnBoardingScreen()
}
package io.h3llo.ecoeats.presentation.on_boarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import io.h3llo.ecoeats.presentation.common.ImageBasic
import io.h3llo.ecoeats.presentation.common.TextBasic
import io.h3llo.ecoeats.presentation.preview.PreviewDefault
import io.h3llo.ecoeats.ui.theme.Primary
import io.h3llo.ecoeats.ui.theme.Secondary


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {

    val pagerState = rememberPagerState()
    val onBoardingList = getDataOnboarding()

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),
                //.background(Color.Blue),
            count = 3,
            state = pagerState
        ) { page ->
            // Text(text = "$page")
            OnBoardingContent(onBoardingPage = onBoardingList[page])
            
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                //.background(Color.Magenta),
            horizontalArrangement = Arrangement.Center

        ) {
            OnBoardingFooter(pagerState = pagerState)
        }

    }
}

@Composable
fun OnBoardingContent(
    modifier: Modifier = Modifier,
    onBoardingPage: OnBoardingPage
) {
    Column(modifier = modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageBasic(
            image = onBoardingPage.image,
            description = "image1",
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.75f)
        )
        TextBasic(
            text = onBoardingPage.title,
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Primary
            )
        )

        TextBasic(
            text = onBoardingPage.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp)
                .padding(24.dp)
            ,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        )



    }
    
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingFooter(
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
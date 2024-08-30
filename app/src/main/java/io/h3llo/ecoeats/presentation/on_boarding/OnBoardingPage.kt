package io.h3llo.ecoeats.presentation.on_boarding

import androidx.annotation.DrawableRes
import io.h3llo.ecoeats.R

data class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title:String,
    val description:String
)

fun getDataOnboarding(): List<OnBoardingPage> {
    return listOf(
        OnBoardingPage (
            image = R.drawable.image1,
            title = "Greetings",
            description = "Lorem Ipsum is simply dummy text of the\n"+
            "printing and typesetting industry."
        ),
        OnBoardingPage (
            image = R.drawable.image2,
            title = "Explore",
            description = "Lorem Ipsum is simply dummy text of the\n"+
            "printing."
        ),OnBoardingPage (
            image = R.drawable.image3,
            title = "Power",
            description = "Lorem Ipsum is simply dummy text of the\n"+
            "printing and typesetting industry printing and typesetting industry."
        ),

    )
}
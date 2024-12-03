package io.h3llo.ecoeats.presentation.home

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem<T>(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: T,
    val hasNews: Boolean,
    val badgeCount: Int?=null
)

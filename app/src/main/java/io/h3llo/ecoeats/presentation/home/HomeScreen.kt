package io.h3llo.ecoeats.presentation.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import io.h3llo.ecoeats.presentation.common.TopBarComponent


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,

    ) {

    val items = listOf(
        BottomNavigationItem(
            title = "Dishes",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = "",
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "Search",
            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search,
            route = "",
            hasNews = false,
            badgeCount = 4
        ),
        BottomNavigationItem(
            title = "Settingd",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            route = "",
            hasNews = true,
        ),

    )

    var selectedItemIndex by remember {
        mutableStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarComponent(
                imageVector = Icons.Filled.Menu,
                onIconClick = { }
            )
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick ={
                            selectedItemIndex = index
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if(item.badgeCount != null){
                                        Text(text = item.badgeCount.toString())
                                    } else if(item.hasNews) {
                                        Badge()

                                    }
                                }
                            ) {
                                Icon(
                                    imageVector =
                                    if( index == selectedItemIndex )
                                        item.selectedIcon
                                    else
                                        item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        }
                    )
                }

            }
        }

    ){ paddingValues ->{}

    }

}
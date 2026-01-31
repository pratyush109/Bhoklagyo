package com.example.bhoklagyo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

import com.example.bhoklagyo.R
import com.example.bhoklagyo.ui.theme.*

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BhoklagyoTheme {
                DashboardBody()
            }
        }
    }
}

@Composable
fun DashboardBody() {

    data class NavItem(val label: String, val icon: Int)
    var selectedIndex by remember { mutableStateOf(0) }

    val navItems = listOf(
        NavItem("Home", R.drawable.ic_home),
        NavItem("Search", R.drawable.ic_search),
        NavItem("Cart", R.drawable.ic_shoppingcart),
        NavItem("Profile", R.drawable.ic_profile),
        NavItem("Notify", R.drawable.ic_notification)
    )

    Scaffold(
        containerColor = Background,

        floatingActionButton = {
            FloatingActionButton(
                onClick = { selectedIndex = 2 },
                containerColor = Primary,
                contentColor = White
            ) {
                Icon(Icons.Default.ShoppingCart, null)
            }
        },

        bottomBar = {
            NavigationBar(containerColor = White) {
                navItems.forEachIndexed { i, item ->
                    NavigationBarItem(
                        selected = selectedIndex == i,
                        onClick = { selectedIndex = i },
                        icon = { Icon(painterResource(item.icon), null) },
                        label = { Text(item.label) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Primary,
                            selectedTextColor = Primary,
                            indicatorColor = Primary.copy(alpha = 0.1f),
                            unselectedIconColor = TextSecondary,
                            unselectedTextColor = TextSecondary
                        )
                    )
                }
            }
        }
    ) { pad ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(pad)
        ) {
            when (selectedIndex) {
                0 -> HomeScreen()
                1 -> SearchScreen()
                2 -> CartScreen()
                3 -> ProfileScreen()
                4 -> NotificationScreen()
            }
        }
    }
}

@Composable
fun SearchScreen() {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    BhoklagyoTheme {
        DashboardBody()
    }
}

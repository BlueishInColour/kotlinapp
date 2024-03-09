package com.example.myfirstkotlin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirstkotlin.data.BottomNavigation
import java.lang.reflect.Modifier
import androidx.compose.material3.MaterialTheme.colorScheme as colorScheme1


val items = listOf(
BottomNavigation(title="Home",icon= Icons.Rounded.Home),
    BottomNavigation(title="Wallet",icon= Icons.Rounded.Wallet),
    BottomNavigation(title="Notification",icon= Icons.Rounded.Notifications),
    BottomNavigation(title="Account",icon= Icons.Rounded.AccountCircle),
)
@Preview
@Composable
fun BottomNavigationBar(){
NavigationBar{
    Row(
//    /*modifier = Modifier.background (colorScheme1.inverseSurface)*/
    ){
        items.forEachIndexed{index,item ->
            NavigationBarItem(
                selected = index ==0,
                onClick={},
                icon={
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
//                        tint = colorScheme1.onBackground
                    )
                },
                label  = {
                    Text(text  =item.title,
//                        color=colorScheme1.onBackground
                    )
                }
            )}
    }
}}
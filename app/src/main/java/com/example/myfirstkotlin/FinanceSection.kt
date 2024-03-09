package com.example.myfirstkotlin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmedapps.bankningappui.ui.theme.BlueStart
import com.ahmedapps.bankningappui.ui.theme.GreenStart
import com.ahmedapps.bankningappui.ui.theme.PurpleStart
import com.example.myfirstkotlin.data.Finance

val finance :List<Finance>  = listOf(
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "Finance\nAnalytics",
        background = BlueStart
),
    Finance(
        icon = Icons.Rounded.Wallet,
        name = "My \nWallet",
        background = PurpleStart
    ),
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My \nTransaction",
        background = GreenStart
    ),
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "My \nWallet",
        background = BlueStart
    ),

    )


    @Preview
    @Composable
        fun FinanceSection(){
            Column{
                Text(text ="Finance", fontSize = 20.sp,
                    color= MaterialTheme.colorScheme.onBackground,
                   fontWeight = FontWeight.Bold,
                    modifier   = Modifier.padding(16.dp)

                    )
                LazyRow {
                    items(finance.size){
                        FinanceItem(it)
                    }
                }
            }
        }

@Composable
fun FinanceItem(index:Int){
val oneFinance = finance[index]
    var lastPaddingEnd = 0.dp
    if(index == finance.size -1){
        lastPaddingEnd = 16.dp


    }

    Column(modifier = Modifier


        .padding(14.dp)

        .clip(RoundedCornerShape(25.dp))


        .background(MaterialTheme.colorScheme.secondaryContainer)

        .padding(14.dp)

        .size(120.dp)
        .clickable { }
,
        verticalArrangement = Arrangement.SpaceEvenly,


    ) {

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(oneFinance.background)
                .padding(vertical = 6.dp, horizontal = 10.dp)

        ) {
            Icon(
                imageVector = oneFinance.icon,
                contentDescription = oneFinance.name,
                tint = Color.White
            )


        }
        Text(
            text = oneFinance.name,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )

    }
}
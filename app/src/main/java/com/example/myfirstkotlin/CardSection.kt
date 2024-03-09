package com.example.myfirstkotlin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ahmedapps.bankningappui.ui.theme.BlueEnd
import com.ahmedapps.bankningappui.ui.theme.BlueStart
import com.ahmedapps.bankningappui.ui.theme.GreenEnd
import com.ahmedapps.bankningappui.ui.theme.GreenStart
import com.ahmedapps.bankningappui.ui.theme.OrangeEnd
import com.ahmedapps.bankningappui.ui.theme.OrangeStart
import com.ahmedapps.bankningappui.ui.theme.PurpleEnd
import com.ahmedapps.bankningappui.ui.theme.PurpleStart
import com.example.myfirstkotlin.data.Card
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

val cards: List<Card> = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "2633 4363 9839 8933",
        cardName = "Oluwapelumi eyeyeye",
        balance = 23.34,
        color = getGradiet(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "2633 4363 9839 8933",
        cardName = "Savings",
        balance = 333.34,
        color = getGradiet(PurpleStart,PurpleEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "2633 3233 9839 8933",
        cardName = "tomodoachi",
        balance = 00.34,
        color = getGradiet(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "2633 4363 9839 8933",
        cardName = "School card",
        balance = 23.34,
        color = getGradiet(GreenStart, GreenEnd)
    ),
)

fun getGradiet(startColor: Color, endColor:Color):Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor,endColor)
    )
}
@Preview
@Composable
fun CardsSection(){
    LazyRow{
        items(cards.size){ index->
            CardItem(index)
        }
    }
}


@Composable
fun CardItem(index:Int){
    
    val card = cards[index]
    var lastItemPadding = 0.dp
    if(index == cards.size - 1){
        lastItemPadding   = 16.dp
    }
    
    var image = painterResource(id = R.drawable.ic_visa)
    
    if(card.cardType == "MASTER CARD"){
        image  = painterResource(id = R.drawable.ic_mastercard)
    }
    
    Box(modifier = Modifier
        .padding(start  = 16.dp,end  = lastItemPadding)
    ){
        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp)
                
            
            )
            .background(card.color)
            .width(250.dp)
            .height(160.dp)
            .clickable {  }
            .padding(vertical =12.dp, horizontal =  16.dp),
            verticalArrangement =   Arrangement.SpaceBetween
        ) {
            
            Image(painter  = image , 
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
                )
            
            Text(text = card.cardName, fontSize = 17.sp ,
                fontWeight = FontWeight.Bold, color = Color.White,
                )
            Text(text = "$ ${card.balance}", fontSize = 22.sp ,
                fontWeight = FontWeight.Bold, color = Color.White,
            )
            Text(text = card.cardNumber, fontSize = 15.sp ,
                fontWeight = FontWeight.Bold, color = Color.White,
            )
        }
    }
}

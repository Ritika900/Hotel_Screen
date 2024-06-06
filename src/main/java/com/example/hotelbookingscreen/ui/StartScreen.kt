package com.example.hotelbookingscreen.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelbookingscreen.data.DataSource
import com.example.hotelbookingscreen.data.Hotels
import com.example.hotelbookingscreen.data.Rooms
import androidx.compose.foundation.layout.Column as Column

@Composable
fun StartScreen()
{
val context= LocalContext.current
    val hotel=DataSource.loadHotels()
    val room=DataSource.loadRooms()
LazyVerticalGrid(columns = GridCells.Adaptive(256.dp), contentPadding = PaddingValues(10.dp),
    verticalArrangement = Arrangement.spacedBy(5.dp), horizontalArrangement = Arrangement.spacedBy(5.dp))
{
items(hotel){h->  val hotelRooms = room.filter { it.hotelName ==  h.hotelName}
    val prices = hotelRooms.map { it.price }
    val minPrice = prices.minOrNull() ?: 0
    val maxPrice = prices.maxOrNull() ?: 0
    if (hotelRooms.isEmpty()) {
        CategoryCard(
            context = context,
            hotelName = h.hotelName,
            stringResourceId = h.stringResourceId,
            imageResourceId = h.imageResourceId,
            priceRange = "Sold Out",
            soldOut = true
        )
    } else {
        CategoryCard(
            context = context,
            hotelName = h.hotelName,
            stringResourceId = h.stringResourceId,
            imageResourceId = h.imageResourceId,
            priceRange = "$minPrice - $maxPrice",
            soldOut = false
        )
    }
}
}
}
@Composable
fun CategoryCard(context: Context,
                 hotelName:String,
                 stringResourceId: Int,
                 imageResourceId: Int,
                 priceRange: String,
                 soldOut: Boolean){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .clickable { Toast.makeText(context, "Hotel Name: $hotelName", Toast.LENGTH_SHORT).show() },
        colors = CardDefaults.cardColors(
            containerColor = if (soldOut) Color.Red else MaterialTheme.colorScheme.surface
        )
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Image(
                painter = painterResource(id = imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = hotelName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = priceRange,
                fontSize = 16.sp,
                color = if (soldOut) Color.White else Color.Black
            )
        }
    }
}


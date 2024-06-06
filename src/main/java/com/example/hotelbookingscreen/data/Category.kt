package com.example.hotelbookingscreen.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hotels(
    val hotelName:String,
    @StringRes val stringResourceId:Int,
    @DrawableRes val imageResourceId:Int
)
data class Rooms(
    val name:String,
    val price:Int,
    val hotelName: String
)

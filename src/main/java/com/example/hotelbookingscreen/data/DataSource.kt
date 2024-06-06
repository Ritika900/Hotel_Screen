package com.example.hotelbookingscreen.data

import com.example.hotelbookingscreen.R

object DataSource {
fun loadHotels(): List<Hotels>{
    return listOf<Hotels>(
      Hotels("JW Marriot",stringResourceId = R.string.jwmarriot, imageResourceId = R.drawable.jwmarriot),
        Hotels("Taj Hotel",stringResourceId =R.string.tajhotel, imageResourceId = R.drawable.tajhotels),
        Hotels("Wyndham",stringResourceId =R.string.wyndham, imageResourceId = R.drawable.wyndham),
        Hotels("Lemon Tree",stringResourceId =R.string.lemontree, imageResourceId = R.drawable.lemontree),
        Hotels("Langham",stringResourceId =R.string.langham, imageResourceId = R.drawable.langham),
        Hotels("Fortune",stringResourceId =R.string.fortune, imageResourceId = R.drawable.fortune)
    )
}
    fun loadRooms():List<Rooms>{
          return listOf<Rooms>(
              Rooms("exclusive",3000,"JW Marriot"),
              Rooms("Deluxe",3500,"Taj Hotel"),
              Rooms("exclusive",2800,"Wyndham"),
              Rooms("Standard",1500,"Lemon Tree"),
              Rooms("Deluxe Suite",4000,"Langham"),
              Rooms("Luxury Suite",5000,"Fortune")
          )
    }
}
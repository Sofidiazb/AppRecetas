package com.example.sofiadiazparcial1


import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Receta(
    val id:Int,
    val nombre:String,
    val dificultad:Dificultad,
    val pais:Pais,
    val ingredientes:String,
    val plato:String

): Parcelable

enum class Dificultad{
    FACIL,
    MEDIO,
    DIFICIL
}
enum class Pais {
    VENEZUELA,
    ARGENTINA,
    MEXICO,
    PERU
}

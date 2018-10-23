package fr.axa.flightachievementtracker

import com.google.gson.annotations.SerializedName

data class Character(val name:String, val realm:String, val level:Int, val stats: CharacterStats)

data class CharacterStats (val health: Int, val power:Int, @SerializedName("str") val strength:Int)

package fr.axa.flightachievementtracker

import com.google.gson.annotations.SerializedName

data class Character(val name:String,
                     val realm:String,
                     val level:Int,
                     val stats: CharacterStats)

data class CharacterStats (val health: Int,
                           val power:Int,
                           @SerializedName("str") val strength:Int)

data class Achievement(val name: String)

data class Realms(val realms:List<Realm>)

data class Realm(val type:String,
                 val population:String,
                 val queue:Boolean,
                 val status: Boolean,
                 val name: String,
                 val slug: String,
                 val battlegroup: String,
                 val locale:String,
                 val timezone: String,
                 val connected_realms: List<String>)

data class Quest(val name: String)

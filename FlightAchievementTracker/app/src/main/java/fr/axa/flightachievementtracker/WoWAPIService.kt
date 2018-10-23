package fr.axa.flightachievementtracker

import fr.axa.flightachievementtracker.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WoWAPIService {

    @GET("wow/character/{realm}/{name}?fields=achievements,reputation,quests,stats,guild&locale=fr_FR&apikey=pkkhjhqfqt9paxx6eezvfd7f6x5hfvee")
    fun getCharacter(@Path("name") name:String, @Path("realm") realm:String): Call<Character>
}
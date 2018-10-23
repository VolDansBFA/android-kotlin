package fr.axa.flightachievementtracker

import fr.axa.flightachievementtracker.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WoWAPIService {

    @GET("wow/character/{realm}/{name}?fields=achievements,reputation,quests,stats,guild&locale=fr_FR")
    fun getCharacter(@Path("name") name:String, @Path("realm") realm:String, @Query("apikey") apiKey: String): Call<Character>
}
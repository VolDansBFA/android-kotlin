package fr.axa.flightachievementtracker.service

import fr.axa.flightachievementtracker.models.raw.Achievement
import fr.axa.flightachievementtracker.models.raw.Character
import fr.axa.flightachievementtracker.models.raw.Quest
import fr.axa.flightachievementtracker.models.raw.Realms
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WoWAPIService {

    @GET("wow/character/{realm}/{name}?fields=achievements,reputation,quests,stats,guild&locale=fr_FR")
    fun getCharacter(@Path("name") name:String,
                     @Path("realm") realm:String,
                     @Query("apikey") apiKey: String): Call<Character>

    @GET("wow/achievement/{achievementId}?locale=fr_FR")
    fun getAchievement(@Path("achievementId")achievementId:String,
                      @Query("apiKey") apiKey: String): Call<Achievement>

    @GET("wow/realm/status?locale=fr_FR")
    fun getRealms(@Query("apiKey") apiKey: String): Call<Realms>

    @GET("wow/quest/{questId}?locale=fr_FR")
    fun getQuest(@Path("questId")questId:String,
                 @Query("apiKey") apiKey: String):Call<Quest>
}
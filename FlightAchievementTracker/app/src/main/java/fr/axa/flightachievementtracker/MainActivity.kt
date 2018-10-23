package fr.axa.flightachievementtracker

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.SERVICE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service:WoWAPIService = retrofit.create(WoWAPIService::class.java)

        val characterCall = service.getCharacter(et_character_name.text.toString(),
            et_realm.text.toString(),
            BuildConfig.API_KEY)

        val questCall = service.getQuest("50328", BuildConfig.API_KEY)

        val realmCall = service.getRealms(BuildConfig.API_KEY)

        val achievementCall = service.getAchievement("6", BuildConfig.API_KEY)

         b_search.setOnClickListener {

             /*
             if (characterCall.isExecuted) {
                 characterCall.cancel()
             } else {
                 characterCall.enqueue(object : Callback<Character> {
                     override fun onFailure(call: Call<Character>, t: Throwable) {
                         tv_result.text = "Failed to get Characters"
                     }

                     override fun onResponse(call: Call<Character>, response: Response<Character>) {
                         tv_result.text = response.body().toString()
                     }

                 })
             }*/

             realmCall.enqueue(object : Callback<Realms> {
                 override fun onFailure(call: Call<Realms>, t: Throwable) {
                     tv_result.text = "Failed to get Realms"
                 }

                 override fun onResponse(call: Call<Realms>, response: Response<Realms>) {
                     val filteredList : List<Realm>? = response.body()?.realms?.filter { it.locale == "fr_FR" }
                     tv_result.text = filteredList.toString()
                 }

             })
        }
    }
}

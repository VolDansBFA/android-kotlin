package fr.axa.flightachievementtracker.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import fr.axa.flightachievementtracker.BuildConfig
import fr.axa.flightachievementtracker.R
import fr.axa.flightachievementtracker.models.raw.Achievement
import fr.axa.flightachievementtracker.models.raw.Character
import fr.axa.flightachievementtracker.models.raw.Quest
import fr.axa.flightachievementtracker.models.raw.Realm
import fr.axa.flightachievementtracker.models.raw.Realms
import fr.axa.flightachievementtracker.service.WoWAPIService
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

        val service: WoWAPIService = retrofit.create(WoWAPIService::class.java)

        val characterCall = service.getCharacter(et_character_name.text.toString(), et_realm.text.toString(),
            BuildConfig.API_KEY
        )

        val questCall = service.getQuest("50328", BuildConfig.API_KEY)

        val realmCall = service.getRealms(BuildConfig.API_KEY)

        val achievementCall = service.getAchievement("6", BuildConfig.API_KEY)

         b_search.setOnClickListener {

             pb_spinner.visibility = View.VISIBLE
             tv_result.text = ""

             //getCharacter(characterCall)

             //getRealms(realmCall)

             //getQuest(questCall)

             getAchievement(achievementCall)
        }
    }




    private fun getCharacter(characterCall: Call<Character>) {
        characterCall.clone().enqueue(object : Callback<Character> {
            override fun onFailure(call: Call<Character>, t: Throwable) {
                displayFailedCalledMessage("Character")
            }

            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                tv_result.text = response.body()
                    .toString() //possible takes time, need to set spinner visibility to task completion
                pb_spinner.visibility = View.INVISIBLE
            }

        })
    }

    private fun getRealms(realmCall: Call<Realms>) {
        realmCall.clone().enqueue(object : Callback<Realms> {
            override fun onFailure(call: Call<Realms>, t: Throwable) {
                displayFailedCalledMessage("Realms")
            }

            override fun onResponse(call: Call<Realms>, response: Response<Realms>) {
                val filteredList: List<Realm>? = response.body()?.realms?.filter { it.locale == "fr_FR" }
                tv_result.text = filteredList.toString()
                pb_spinner.visibility = View.INVISIBLE
            }

        })
    }

    private fun getQuest(questCall: Call<Quest>) {
        questCall.clone().enqueue(object : Callback<Quest> {
            override fun onFailure(call: Call<Quest>, t: Throwable) {
                displayFailedCalledMessage("Quest")
            }

            override fun onResponse(call: Call<Quest>, response: Response<Quest>) {
                tv_result.text = response.body()
                    .toString() //possible takes time, need to set spinner visibility to task completion
                pb_spinner.visibility = View.INVISIBLE
            }

        })
    }

    private fun getAchievement(achievementCall: Call<Achievement>) {
        achievementCall.clone().enqueue(object : Callback<Achievement> {
            override fun onFailure(call: Call<Achievement>, t: Throwable) {
                displayFailedCalledMessage("Achievemnent")
            }

            override fun onResponse(call: Call<Achievement>, response: Response<Achievement>) {
                tv_result.text = response.body()
                    .toString() //possible takes time, need to set spinner visibility to task completion
                pb_spinner.visibility = View.INVISIBLE
            }

        })
    }

    private fun displayFailedCalledMessage(callName:String) {
        tv_result.text = "Failed to get {$callName}"
        pb_spinner.visibility = View.INVISIBLE
    }
}

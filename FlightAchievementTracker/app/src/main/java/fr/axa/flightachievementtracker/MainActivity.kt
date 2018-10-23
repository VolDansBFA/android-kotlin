package fr.axa.flightachievementtracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), Callback<Character> {
    override fun onFailure(call: Call<Character>, t: Throwable) {
        if (!call.isCanceled) {
            tv_result.text = "Failed to get Character"
        }
    }

    override fun onResponse(call: Call<Character>, response: Response<Character>) {
        tv_result.text = response.body().toString()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://eu.api.battle.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service:WoWAPIService = retrofit.create(WoWAPIService::class.java)

        val call = service.getCharacter("Odiryna","Archimonde")

         b_search.setOnClickListener {

             if (call.isExecuted) {
                 call.cancel()
             } else {
                 call.enqueue(this)
             }
        }
    }
}

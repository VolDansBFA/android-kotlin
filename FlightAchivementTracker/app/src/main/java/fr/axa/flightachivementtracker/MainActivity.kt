package fr.axa.flightachivementtracker

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),
        AddCharacterFragment.OnFragmentInteractionListener,
        CharacterListFragment.OnFragmentInteractionListener,
        AchievementListFragment.OnFragmentInteractionListener,
        AchivementDetailFragment.OnFragmentInteractionListener,
        AvailableCharactersFragment.OnFragmentInteractionListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onFragmentInteraction(uri: Uri) {

        Log.e("MainActivity", uri.toString())
    }
}

package fr.axa.flightachievementtracker

import android.app.Application
import androidx.room.Room
import fr.axa.flightachievementtracker.models.room.quest.QuestDatabase

class FlightAchievementTrackerApplication : Application() {

    companion object {
        lateinit var database: QuestDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, QuestDatabase::class.java,"quest_database").build()
    }
}
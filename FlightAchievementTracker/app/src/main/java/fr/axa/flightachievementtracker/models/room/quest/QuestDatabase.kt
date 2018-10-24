package fr.axa.flightachievementtracker.models.room.quest

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(Quest::class)], version = 1)
abstract class QuestDatabase : RoomDatabase() {
    abstract fun questDao(): QuestDao
}
package fr.axa.flightachievementtracker.models.room.quest

import androidx.lifecycle.LiveData

interface QuestRepository {
    fun saveQuest(quest: Quest)
    fun getAllQuests(): LiveData<List<Quest>>
    fun clearAllQuests()
    fun getQuest(questId:Int)

}



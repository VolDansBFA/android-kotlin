package fr.axa.flightachievementtracker.models.room.quest

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import fr.axa.flightachievementtracker.FlightAchievementTrackerApplication

class RoomRepository : QuestRepository {

    private val questDao: QuestDao = FlightAchievementTrackerApplication.database.questDao()

    private val allQuests: LiveData<List<Quest>>

    init {
        allQuests = questDao.getAllQuests()
    }
    override fun saveQuest(quest: Quest) {
        InsertAsyncTask(questDao).execute(quest)
    }

    override fun getAllQuests(): LiveData<List<Quest>> = allQuests

    override fun clearAllQuests() {
        val questArray = allQuests.value?.toTypedArray()

        if (questArray != null) {
            DeleteAsyncTask(questDao).execute(*questArray)
        }
    }

    override fun getQuest(questId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private class InsertAsyncTask internal constructor(private val dao: QuestDao) : AsyncTask<Quest, Void, Void?>() {
        override fun doInBackground(vararg params: Quest): Void? {
            dao.insert(params[0])
            return null
        }
    }

    private class DeleteAsyncTask internal constructor(private val dao: QuestDao) : AsyncTask<Quest, Void, Void?>() {
        override fun doInBackground(vararg params: Quest): Void? {
            dao.clearQuests(*params)
            return null
        }

    }

}
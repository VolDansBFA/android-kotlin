package fr.axa.flightachievementtracker.models.room.quest

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QuestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(quest: Quest)

    @Delete
    fun clearQuests(vararg quest: Quest)

    @Query("SELECT * FROM quest_table ORDER BY id ASC")
    fun getAllQuests(): LiveData<List<Quest>>
}
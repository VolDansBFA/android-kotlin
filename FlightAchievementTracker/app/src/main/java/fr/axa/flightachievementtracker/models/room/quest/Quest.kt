package fr.axa.flightachievementtracker.models.room.quest

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quest_table")
data class Quest (
    @PrimaryKey @NonNull val id: Int,
    val title: String = "",
    val reqLevel: Int = 0,
    val suggestedPartyMembers: Int = 0,
    val category: String = "",
    val level: Int = 0)
package fr.axa.flightachievementtracker

import com.google.gson.annotations.SerializedName

data class Character(val lastModified: Long,
                     val name:String,
                     val realm:String,
                     val battlegroup:String,
                     @SerializedName("class") val characterClass:Int,
                     val race: Int,
                     val gender: Int,
                     val level:Int,
                     val achievementPoints:Int,
                     val thumbnail:String,
                     val calcClass:String,
                     val faction:Int,
                     val stats: CharacterStats,
                     val reputation:List<CharacterReputation>,
                     val achievements:CharacterAchievements,
                     val quests:List<Int>,
                     val totalHonorableKills:Int
)

data class CharacterStats (val health: Int,
                           val power:Int,
                           @SerializedName("str") val strength:Int)

data class CharacterReputation(val id:Int,
                               val name:String,
                               val standing: Int,
                               val value: Int,
                               val max: Int)

data class CharacterAchievements(val achievementsCompleted:List<Int>,
                                 val achievementsCompletedTimestamp: List<Long>,
                                 val criteria:List<Int>,
                                 val criteriaQuantity:List<Long>,
                                 val criteriaTimestamp:List<Long>,
                                 val criteriaCreated:List<Long>)
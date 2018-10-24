package fr.axa.flightachievementtracker.models.raw

data class Achievement(val id: Int,
                       val title: String,
                       val points: Int,
                       val description: String,
                       //val rewardItems: List<Int>,
                       val icon:String,
                       val criteria: List<AchievementCriteria>,
                       val accountWide:Boolean,
                       val factionId: Int)

data class AchievementCriteria (val id:Int,
                                val description: String,
                                val orderIndex: Int,
                                val max: Int)

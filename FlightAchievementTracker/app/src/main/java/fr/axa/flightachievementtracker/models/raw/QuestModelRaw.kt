package fr.axa.flightachievementtracker.models.raw

data class Quest(val id: Int,
                 val title: String,
                 val reqLevel: Int,
                 val suggestedPartyMembers: Int,
                 val category: String,
                 val level: Int)
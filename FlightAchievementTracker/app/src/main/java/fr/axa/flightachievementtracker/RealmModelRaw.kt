package fr.axa.flightachievementtracker

data class Realms(val realms:List<Realm>)
data class Realm(val type:String,
                 val population:String,
                 val queue:Boolean,
                 val status: Boolean,
                 val name: String,
                 val slug: String,
                 val battlegroup: String,
                 val locale:String,
                 val timezone: String,
                 val connected_realms: List<String>)
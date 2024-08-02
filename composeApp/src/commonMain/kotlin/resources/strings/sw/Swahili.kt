package resources.strings.sw

import resources.strings.IStringResources

data class Swahili(
    override val appName: String = "Jetflix",
    override val home: String = "Nyumbani",
    override val search: String = "Tafuta",
    override val myTrips: String = "Maagizo",
    override val notification: String = "Taarifa",
    override val profile: String = "Profaili",
    override val cancelledTrips: String= "Cancelled",
    override val upcomingTrips: String = "Upcoming",
    override val completedTrips: String = "Upcoming",
): IStringResources

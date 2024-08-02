package resources.strings.en

import resources.strings.IStringResources

data class English(
    override val appName: String = "Jetflix",
    override val home: String = "Home",
    override val search: String = "Book",
    override val myTrips: String = "MyTrips",
    override val notification: String = "Notification",
    override val profile: String = "Profile",
    override val cancelledTrips: String = "Cancelled",
    override val upcomingTrips: String = "Upcoming",
    override val completedTrips: String = "Complited",
): IStringResources

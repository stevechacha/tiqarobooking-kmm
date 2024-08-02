package presentation.myTrips

import presentation.common.base.ErrorState

data class MyTripsScreenUIState(
    val selectedType: MyTripsType = MyTripsType.UPCOMING,
    val isLoggedIn: Boolean = false,
    val isLoading: Boolean = false,
    val error: ErrorState? = null
){
    enum class MyTripsType {
        UPCOMING,
        COMPLETED,
        CANCELLED
    }
}

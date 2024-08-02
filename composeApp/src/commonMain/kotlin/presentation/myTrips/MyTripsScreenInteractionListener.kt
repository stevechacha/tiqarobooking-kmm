package presentation.myTrips

import presentation.common.base.BaseInteractionListener

interface MyTripsScreenInteractionListener : BaseInteractionListener {
    fun onClickTab(type: MyTripsScreenUIState.MyTripsType)
    fun onClickLogin()

}
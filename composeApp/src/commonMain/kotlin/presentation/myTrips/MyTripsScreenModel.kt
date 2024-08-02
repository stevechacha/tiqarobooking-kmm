package presentation.myTrips

import cafe.adriel.voyager.core.model.screenModelScope
import domain.usecase.IManageAuthenticationUseCase
import domain.usecase.ManageAuthenticationUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import presentation.common.base.BaseScreenModel
import presentation.common.base.ErrorState

class MyTripsScreenModel(
    private val manageAuthentication: IManageAuthenticationUseCase,
) : BaseScreenModel<MyTripsScreenUIState, MyTripsScreenUiEffect>(MyTripsScreenUIState()),
    MyTripsScreenInteractionListener {

    override val viewModelScope: CoroutineScope = screenModelScope

    init {
        updateState { it.copy(isLoading = true) }
    }

    private fun checkIfLoggedIn() {
        tryToExecute(
            { manageAuthentication.getAccessToken() },
            ::onCheckIfLoggedInSuccess,
            ::onCheckIfLoggedInError
        )
    }

    private fun onCheckIfLoggedInSuccess(accessToken: Flow<String>) {
        screenModelScope.launch {
            accessToken.collect { token ->
                if (token.isNotEmpty()) {
                    updateState { it.copy(isLoggedIn = true) }
                } else {
                    updateState { it.copy(isLoggedIn = false) }
                }
            }
        }
    }

    private fun onCheckIfLoggedInError(errorState: ErrorState) {
        updateState { it.copy(isLoggedIn = false, isLoading = false) }
    }


    private fun onError(errorState: ErrorState) {
        updateState { it.copy(isLoading = false, error = errorState) }
    }

    override fun onClickTab(type: MyTripsScreenUIState.MyTripsType) {
        updateState { it.copy(selectedType = type) }
    }


    override fun onClickLogin() {
        sendNewEffect(MyTripsScreenUiEffect.NavigateToLoginScreen)
    }
}

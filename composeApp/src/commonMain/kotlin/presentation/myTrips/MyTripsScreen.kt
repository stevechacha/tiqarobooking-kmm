package presentation.myTrips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import presentation.LoginScreen
import presentation.common.base.BaseScreen
import presentation.common.theme.tqColorsPalette
import presentation.common.theme.tqTypography
import resources.Resources
import util.capitalizeFirstLetter
import util.root

class MyTripsScreen :
    BaseScreen<MyTripsScreenModel, MyTripsScreenUIState, MyTripsScreenUiEffect, MyTripsScreenInteractionListener>() {

    @Composable
    override fun Content() {
        initScreen(getScreenModel())
    }

    override fun onEffect(effect: MyTripsScreenUiEffect, navigator: Navigator) {
        when (effect) {
            MyTripsScreenUiEffect.NavigateToLoginScreen -> navigator.root?.push(LoginScreen())
        }

    }

    @Composable
    override fun onRender(state: MyTripsScreenUIState, listener: MyTripsScreenInteractionListener) {
        val tabs = listOf(Resources.strings.upcomingTrips,Resources.strings.completedTrips,Resources.strings.cancelledTrips)
        var selectedTab by rememberSaveable { mutableStateOf(0) }

        BoxWithConstraints(Modifier.fillMaxSize().padding()) {
            BoxWithConstraints(Modifier.fillMaxSize(), Alignment.TopCenter) {
                TabRow(
                    selectedTabIndex = selectedTab,
                    indicator = { tabPositions ->
                        if (selectedTab < tabPositions.size) {
                            TabRowDefaults.SecondaryIndicator(
                                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                                height = 2.dp,
                                color = MaterialTheme.tqColorsPalette.primary
                            )
                        }
                    },
                    tabs = {
                        tabs.forEachIndexed { index, type ->
                            Tab(
                                selected = selectedTab == index,
                                onClick = { selectedTab = index },
                                text = {
                                    Text(
                                        text = type.capitalizeFirstLetter(),
                                        color = if (selectedTab == index) {
                                            MaterialTheme.tqColorsPalette.primary
                                        } else MaterialTheme.tqColorsPalette.contentPrimary,
                                        style = MaterialTheme.tqTypography.titleMedium
                                    )
                                }
                            )
                        }
                    }
                )
            }
            BoxWithConstraints(Modifier.fillMaxSize(), Alignment.Center) {
                Column(
                    modifier = Modifier.padding(5.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    when (selectedTab) {
                        0 -> { Text("Home Tab Content") }
                        1 -> { Text("Favourites Tab Content") }
                        2 -> { Text("Settings Tab Content") }
                    }
                }
            }
        }
    }
}
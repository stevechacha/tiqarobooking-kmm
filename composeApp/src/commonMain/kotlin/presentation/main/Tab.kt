package presentation.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.TripOrigin
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.TripOrigin
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import presentation.book.BookingScreen
import presentation.home.HomeScreen
import presentation.myTrips.MyTripsScreen
import presentation.profile.ProfileScreen
import resources.Resources


object HomeTab : Tab {
    override val options: TabOptions
        @Composable get() {
            val title = Resources.strings.home
            return remember { TabOptions(index = 0u, title = title) }
        }

    @Composable
    override fun Content() {
        Navigator(screen = HomeScreen()) {
            SlideTransition(it)
        }
    }

}

object SearchTab : Tab {

    override val options: TabOptions
        @Composable get() {
            val title = Resources.strings.search
            return remember { TabOptions(index = 1u, title = title) }
        }

    @Composable
    override fun Content() {
        Navigator(screen = BookingScreen()) {
            SlideTransition(it)
        }
    }
}

object OrdersTab : Tab {
    override val options: TabOptions
        @Composable get() {
            val title = Resources.strings.myTrips
            return remember { TabOptions(index = 2u, title = title) }
        }

    @Composable
    override fun Content() {
        Navigator(screen = MyTripsScreen()) {
            SlideTransition(it)
        }
    }
}


object ProfileTab : Tab {
    override val options: TabOptions
        @Composable get() {
            val title = Resources.strings.profile
            return remember { TabOptions(index = 4u, title = title) }
        }

    @Composable
    override fun Content() {
        Navigator(screen = ProfileScreen()) {
            SlideTransition(it)
        }
    }
}

@Composable
fun rememberTabsContainer(): List<TabContainer> {
    val images = Resources.images
    return remember {
        listOf(
            TabContainer(
                HomeTab,
                selectedIcon = Icons.Filled.Home,
                unSelectedIcon = Icons.Outlined.Home
            ), TabContainer(
                SearchTab,
                selectedIcon = Icons.Filled.Search,
                unSelectedIcon = Icons.Outlined.Search
            ), TabContainer(
                OrdersTab,
                selectedIcon = Icons.Filled.TripOrigin,
                unSelectedIcon = Icons.Outlined.TripOrigin
            ), TabContainer(
                ProfileTab,
                selectedIcon = Icons.Filled.Person,
                unSelectedIcon = Icons.Outlined.Person
            )
        )
    }
}

data class TabContainer(
    val tab: Tab,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
)

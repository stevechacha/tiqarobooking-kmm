package presentation.app

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.main.MainContainer
import resources.TqBookingTheme

@Composable
@Preview
fun App() {
    MainApp.Content()
}

object MainApp : Screen {
    @Composable
    override fun Content() {
        TqBookingTheme {
            Navigator(MainContainer) { SlideTransition(it) }
        }
    }

}
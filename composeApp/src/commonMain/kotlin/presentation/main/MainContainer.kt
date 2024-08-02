package presentation.main

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import presentation.common.composable.TqNavigationBar
import presentation.common.composable.TqNavigationBarItem
import presentation.common.exitinstion.drawTopIndicator
import presentation.common.theme.tqColorsPalette
import util.getNavigationBarPadding

object MainContainer : Screen {

    @Composable
    override fun Content() {
        TabNavigator(HomeTab) {
            Scaffold(
                bottomBar = {
                    val tabNavigator = LocalTabNavigator.current
                    val tabs = rememberTabsContainer()
                    BottomBar(tabs, tabNavigator)
                },
                content = {
                    Column(Modifier.fillMaxSize().padding(bottom = it.calculateBottomPadding())) {
                        CurrentTab()
                    }
                },
                containerColor = MaterialTheme.tqColorsPalette.background,
            )
        }
    }

    @Composable
    private fun BottomBar(tabs: List<TabContainer>, tabNavigator: TabNavigator) {
        var xIndicatorOffset by remember { mutableStateOf(Float.NaN) }
        val xOffsetAnimated by animateFloatAsState(targetValue = xIndicatorOffset)


        TqNavigationBar(
            modifier = Modifier.background(MaterialTheme.tqColorsPalette.surface)
                .drawTopIndicator(xOffsetAnimated).padding(getNavigationBarPadding())
        ) {
            tabs.forEach { tabContainer ->
                val selected = tabNavigator.current == tabContainer.tab
                val drawable =
                    if (selected) tabContainer.selectedIcon else tabContainer.unSelectedIcon

                TqNavigationBarItem(
                    icon = { color ->
                        Icon(
                            imageVector = drawable,
                            contentDescription = null,
                            tint = color
                        )
                    },
                    label = {
                        Text(
                            text = tabContainer.tab.options.title, style = it,
                            color = if (selected) MaterialTheme.tqColorsPalette.primary else MaterialTheme.tqColorsPalette.contentTertiary
                        )
                    },
                    selected = selected,
                    onClick = { tabNavigator.current = tabContainer.tab },
                )
            }
        }
    }
}
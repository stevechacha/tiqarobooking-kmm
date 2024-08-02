package presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import epicarchitect.calendar.compose.basis.config.DefaultBasisEpicCalendarConfig
import epicarchitect.calendar.compose.basis.config.LocalBasisEpicCalendarConfig
import epicarchitect.calendar.compose.basis.config.rememberBasisEpicCalendarConfig
import epicarchitect.calendar.compose.datepicker.config.DefaultEpicDatePickerConfig
import epicarchitect.calendar.compose.datepicker.config.LocalEpicDatePickerConfig
import epicarchitect.calendar.compose.pager.EpicCalendarPager
import epicarchitect.calendar.compose.pager.config.DefaultEpicCalendarPagerConfig
import epicarchitect.calendar.compose.pager.config.LocalEpicCalendarPagerConfig
import epicarchitect.calendar.compose.pager.config.rememberEpicCalendarPagerConfig
import epicarchitect.calendar.compose.pager.state.rememberEpicCalendarPagerState

class HomeScreen : Screen{
    @Composable
    override fun Content() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val defaultBasisConfig = DefaultBasisEpicCalendarConfig.copy(
                contentPadding = PaddingValues(horizontal = 16.dp),
                displayDaysOfAdjacentMonths = false,
                displayDaysOfWeek = false,
                rowsSpacerHeight = 2.dp
            )
            val defaultPagerConfig = DefaultEpicCalendarPagerConfig.copy(
                basisConfig = defaultBasisConfig
            )
            val defaultDatePickerConfig = DefaultEpicDatePickerConfig.copy(
                pagerConfig = defaultPagerConfig,
                selectionContainerColor = MaterialTheme.colorScheme.primary,
                selectionContentColor = MaterialTheme.colorScheme.onPrimary
            )
            CompositionLocalProvider(
                LocalBasisEpicCalendarConfig provides defaultBasisConfig,
                LocalEpicCalendarPagerConfig provides defaultPagerConfig,
                LocalEpicDatePickerConfig provides defaultDatePickerConfig
            ) {
                EpicCalendarPager(
                    state = rememberEpicCalendarPagerState(
                        config = rememberEpicCalendarPagerConfig(
                            basisConfig = rememberBasisEpicCalendarConfig(
                                contentColor = Color.Red
                            )
                        )
                    )
                )
            }
        }
    }
}
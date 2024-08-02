package presentation.common.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import presentation.common.composable.modifier.noRippleEffect
import org.jetbrains.compose.resources.ExperimentalResourceApi
import presentation.common.theme.tqColorsPalette
import presentation.common.theme.tqTypography

@OptIn(ExperimentalMaterial3Api::class, ExperimentalResourceApi::class)
@Composable
fun TqAppBar(
    onNavigateUp: (() -> Unit)? = null,
    title: String = "",
    modifier: Modifier = Modifier,
    isBackIconVisible: Boolean = true,
    painterResource :Painter? = null,
    leading: (@Composable (() -> Unit))? = null,
    actions: (@Composable (() -> Unit))? = null
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.tqTypography.titleLarge,
                color = MaterialTheme.tqColorsPalette.contentPrimary
            )
        },
        navigationIcon = {
            if (isBackIconVisible) {
                if (painterResource != null) {
                    Icon(
                        painter = painterResource,
                        contentDescription = "",
                        modifier = Modifier.noRippleEffect { onNavigateUp?.invoke() }
                            .padding(start = 16.dp, end = 16.dp),
                        tint = MaterialTheme.tqColorsPalette.contentSecondary,
                    )
                }
            } else {
                leading?.invoke()
            }

        },
        actions = {
            actions?.invoke()
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.tqColorsPalette.surface),
        modifier = modifier,
    )
}


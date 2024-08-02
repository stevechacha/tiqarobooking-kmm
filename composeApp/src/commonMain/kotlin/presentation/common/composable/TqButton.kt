package presentation.common.composable

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import presentation.common.theme.tqColorsPalette
import presentation.common.theme.tqDimens
import presentation.common.theme.tqRadius
import presentation.common.theme.tqTypography

@ExperimentalMaterial3Api
@Composable
fun TqButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    painter: Painter? = null,
    enabled: Boolean = true,
    textPadding: PaddingValues = PaddingValues(MaterialTheme.tqDimens.space16),
    shape: Shape = RoundedCornerShape(MaterialTheme.tqRadius.medium),
    containerColor: Color = MaterialTheme.tqColorsPalette.primary,
    contentColor: Color = MaterialTheme.tqColorsPalette.onPrimary,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    isLoading: Boolean = false,
) {
    val buttonColor by animateColorAsState(
        if (enabled) containerColor else MaterialTheme.tqColorsPalette.disable
    )

    Surface(
        modifier = modifier.height(56.dp),
        onClick = onClick,
        shape = shape,
        color = buttonColor,
        enabled = enabled,
        contentColor = contentColor,
    ) {
        Row(
            Modifier.defaultMinSize(
                minWidth = ButtonDefaults.MinWidth,
                minHeight = ButtonDefaults.MinHeight
            ),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            painter?.let {
                Image(
                    modifier = Modifier.size(MaterialTheme.tqDimens.space24).padding(end = MaterialTheme.tqDimens.space8),
                    painter = painter,
                    contentDescription = null
                )
            }
            AnimatedContent(targetState = isLoading) {
                if (isLoading) BpThreeDotLoadingIndicator()
                else Text(
                    text = title,
                    style = MaterialTheme.tqTypography.titleLarge.copy(color = contentColor),
                    modifier = Modifier.padding(textPadding)
                )
            }
        }
    }
}
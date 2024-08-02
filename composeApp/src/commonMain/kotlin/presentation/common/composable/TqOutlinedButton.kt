package presentation.common.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import presentation.common.theme.tqColorsPalette
import presentation.common.theme.tqDimens
import presentation.common.theme.tqRadius
import presentation.common.theme.tqTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TqOutlinedButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textStyle: TextStyle = MaterialTheme.tqTypography.titleLarge,
    textPadding: PaddingValues = PaddingValues(MaterialTheme.tqDimens.space16),
    shape: Shape = RoundedCornerShape(MaterialTheme.tqRadius.medium),
    contentColor: Color = MaterialTheme.tqColorsPalette.primary,
    border: BorderStroke = BorderStroke(1.dp, color = MaterialTheme.tqColorsPalette.primary),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center
) {
    val buttonBorderColor by animateColorAsState(
        if (enabled) MaterialTheme.tqColorsPalette.primary
        else MaterialTheme.tqColorsPalette.disable
    )

    val buttonContentColor by animateColorAsState(
        if (enabled) contentColor
        else MaterialTheme.tqColorsPalette.disable
    )

    Surface(
        modifier = modifier.height(56.dp),
        onClick = onClick,
        shape = shape,
        enabled = enabled,
        color = Color.Transparent,
        contentColor = buttonContentColor,
        border = BorderStroke(border.width, buttonBorderColor)
    ) {
        Row(
            Modifier
                .defaultMinSize(
                    minWidth = ButtonDefaults.MinWidth,
                    minHeight = ButtonDefaults.MinHeight
                ),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title,
                style = textStyle,
                color = buttonContentColor ,
                modifier = Modifier.padding(textPadding)
            )
        }
    }
}
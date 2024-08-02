package presentation.common.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import presentation.common.theme.tqColorsPalette
import presentation.common.theme.tqRadius
import presentation.common.theme.tqTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TqChip(
    label: String,
    isSelected: Boolean,
    onClick: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    painter: Painter? = null
) {
    val containerColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.tqColorsPalette.primary else Color.Transparent
    )
    val labelColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.tqColorsPalette.onPrimary
        else MaterialTheme.tqColorsPalette.contentSecondary
    )
    val iconColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.tqColorsPalette.onPrimary
        else MaterialTheme.tqColorsPalette.contentSecondary
    )
    AssistChip(
        modifier = modifier.height(32.dp),
        onClick = { onClick(!isSelected) },
        label = { Text(text = label, style = MaterialTheme.tqTypography.titleMedium) },
        leadingIcon = {
            painter?.let {
                Icon(
                    painter = painter,
                    contentDescription = "$label icon",
                    Modifier.size(AssistChipDefaults.IconSize),
                    tint = iconColor
                )
            }
        },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = containerColor,
            labelColor = labelColor
        ),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.tqColorsPalette.divider
        ),
        shape = RoundedCornerShape(MaterialTheme.tqRadius.small)
    )
}
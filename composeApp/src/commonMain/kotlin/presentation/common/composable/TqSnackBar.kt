package presentation.common.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import presentation.common.theme.tqColorsPalette
import presentation.common.theme.tqDimens
import presentation.common.theme.tqRadius

@Composable
fun TqSnackBar(
    icon: Painter,
    modifier: Modifier = Modifier,
    isVisible: Boolean = true,
    iconTint: Color = MaterialTheme.tqColorsPalette.primary,
    iconBackgroundColor: Color = MaterialTheme.tqColorsPalette.hover,
    backgroundColor: Color = MaterialTheme.tqColorsPalette.surface,
    content: @Composable () -> Unit,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically { it },
        exit = slideOutVertically { it },
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = MaterialTheme.tqDimens.space16, vertical = MaterialTheme.tqDimens.space24)
                .clip(RoundedCornerShape(MaterialTheme.tqRadius.medium))
                .background(backgroundColor)
                .padding(horizontal = MaterialTheme.tqDimens.space16, vertical = MaterialTheme.tqDimens.space8),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.tqDimens.space8)
        ) {
            Icon(
                modifier = Modifier.background(
                    color = iconBackgroundColor,
                    shape = RoundedCornerShape(MaterialTheme.tqRadius.medium)
                ).padding(MaterialTheme.tqDimens.space8),
                painter = icon,
                contentDescription = null,
                tint = iconTint
            )
            content()
        }
    }
}
package presentation.common.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import presentation.common.theme.tqColorsPalette
import presentation.common.theme.tqDimens
import presentation.common.theme.tqRadius
import presentation.common.theme.tqTypography

@Composable
fun TqTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    heightInDp: Int = 32,
) {
    Surface(
        modifier = modifier
            .height(heightInDp.dp)
            .border(width = 1.dp, color = MaterialTheme.tqColorsPalette.contentBorder, shape = RoundedCornerShape(MaterialTheme.tqRadius.small))
            .padding(horizontal = MaterialTheme.tqDimens.space16, vertical = MaterialTheme.tqDimens.space8)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { onClick() },
        color = Color.Transparent,
    ) {
        Text(text = text, style = MaterialTheme.tqTypography.bodySmall, color = MaterialTheme.tqColorsPalette.onPrimary,)
    }
}
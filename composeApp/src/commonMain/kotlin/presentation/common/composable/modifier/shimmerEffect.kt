package presentation.common.composable.modifier


import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import presentation.common.theme.tqColorsPalette

@Composable
fun Modifier.shimmerEffect(
    colors: List<Color> = listOf(
        MaterialTheme.tqColorsPalette.disable,
        MaterialTheme.tqColorsPalette.disable.copy(alpha = 0.5f),
        MaterialTheme.tqColorsPalette.disable,
    ),
    durationMillis: Int = 1000,
): Modifier = composed {
    var size by remember { mutableStateOf(IntSize.Zero) }
    val transition = rememberInfiniteTransition()
    val startOffset by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis),
        ),
    )

    background(
        brush = Brush.linearGradient(
            colors = colors,
            start = Offset(startOffset, 0f),
            end = Offset(startOffset + size.width, size.height.toFloat()),
        )
    ).onGloballyPositioned { size = it.size }
}
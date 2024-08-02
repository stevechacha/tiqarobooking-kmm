package presentation.common.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import presentation.common.composable.modifier.noRippleEffect
import presentation.common.theme.tqColorsPalette
import presentation.common.theme.tqRadius
import presentation.common.theme.tqTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TqSimpleTextField(
    text: String,
    hint: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit = {},
    hintColor: Color = MaterialTheme.tqColorsPalette.contentTertiary,
    modifier: Modifier = Modifier,
    trailingPainter: Painter? = null,
    leadingPainter: Painter? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    radius: Dp =MaterialTheme.tqRadius.medium,
    errorMessage: String = "",
    isError: Boolean = errorMessage.isNotEmpty(),
    onTrailingIconClick: () -> Unit = {},
    isSingleLine: Boolean = true,
    trailingIconEnabled: Boolean = onTrailingIconClick != {},
    outlinedTextFieldDefaults: TextFieldColors = OutlinedTextFieldColorDefaults()
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().heightIn(min = 56.dp, max = 160.dp),
            value = text,
            placeholder = {
                Text(
                    hint,
                    style = MaterialTheme.tqTypography.bodySmall,
                    color = hintColor,
                )
            },
            onValueChange = onValueChange,
            shape = RoundedCornerShape(radius),
            textStyle = MaterialTheme.tqTypography.bodySmall.copy(color = MaterialTheme.tqColorsPalette.contentPrimary),
            singleLine = isSingleLine,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            isError = isError,
            trailingIcon = {
                trailingPainter?.let {
                    IconButton(
                        onClick = onTrailingIconClick,
                        enabled = trailingIconEnabled,
                    ) {
                        Icon(
                            painter = trailingPainter,
                            contentDescription = "trailing icon",
                            tint = MaterialTheme.tqColorsPalette.contentTertiary
                        )
                    }
                }
            },
            leadingIcon = if (leadingPainter != null) {
                {
                    Icon(
                        painter = leadingPainter,
                        contentDescription = "leading icon",
                        tint = MaterialTheme.tqColorsPalette.contentSecondary,
                        modifier = Modifier.noRippleEffect(onClick)
                    )
                }
            } else null,
            colors = outlinedTextFieldDefaults,
        )
        AnimatedVisibility(isError) {
            Text(
                text = errorMessage,
                modifier = Modifier.padding(top = 8.dp),
                style = MaterialTheme.tqTypography.labelSmall,
                color = MaterialTheme.tqColorsPalette.primary
            )
        }
    }

}

@Composable
fun OutlinedTextFieldColorDefaults() = OutlinedTextFieldDefaults.colors(
    focusedContainerColor = MaterialTheme.tqColorsPalette.surface,
    unfocusedContainerColor = MaterialTheme.tqColorsPalette.surface,
    cursorColor = MaterialTheme.tqColorsPalette.contentTertiary,
    errorCursorColor = MaterialTheme.tqColorsPalette.primary,
    focusedBorderColor = MaterialTheme.tqColorsPalette.contentTertiary.copy(alpha = 0.2f),
    unfocusedBorderColor = MaterialTheme.tqColorsPalette.contentBorder.copy(alpha = 0.1f),
    errorBorderColor = MaterialTheme.tqColorsPalette.primary.copy(alpha = 0.5f),
)


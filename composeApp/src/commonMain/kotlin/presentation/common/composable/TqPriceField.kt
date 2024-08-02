package presentation.common.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import presentation.common.theme.tqColorsPalette
import presentation.common.theme.tqDimens
import presentation.common.theme.tqRadius
import presentation.common.theme.tqTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TqPriceField(
    text: String,
    onValueChange: (String) -> Unit,
    flag: Painter,
    currency: String,
    modifier: Modifier = Modifier,
    label: String = "",
    hint: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    shapeRadius: Shape = RoundedCornerShape(MaterialTheme.tqRadius.medium),
    errorMessage: String = "",
    correctValidation: Boolean = false,
    isError: Boolean = errorMessage.isNotEmpty(),

    ) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(bottom = MaterialTheme.tqDimens.space8),
            style = MaterialTheme.tqTypography.titleSmall,
            color = MaterialTheme.tqColorsPalette.contentPrimary
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().height(56.dp),
            value = text,
            placeholder = {
                Text(
                    hint,
                    style = MaterialTheme.tqTypography.labelSmall,
                    color = MaterialTheme.tqColorsPalette.contentTertiary
                )
            },
            onValueChange = onValueChange,
            shape = shapeRadius,
            textStyle = MaterialTheme.tqTypography.bodySmall.copy(MaterialTheme.tqColorsPalette.contentPrimary),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            trailingIcon = {
                Row(
                    modifier = Modifier.padding(end = MaterialTheme.tqDimens.space8),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(MaterialTheme.tqDimens.space8)
                ) {
                    Image(
                        painter = flag,
                        contentDescription = currency,)
                    Text(
                        text = currency,
                        style = MaterialTheme.tqTypography.bodySmall,
                        color = MaterialTheme.tqColorsPalette.contentSecondary
                    )
                }

            },
            isError = isError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = ContainerColor(isError, correctValidation),
                unfocusedBorderColor = MaterialTheme.tqColorsPalette.contentBorder.copy(alpha = 0.1f),
                focusedBorderColor = MaterialTheme.tqColorsPalette.contentTertiary.copy(alpha = 0.2f),
                errorBorderColor = MaterialTheme.tqColorsPalette.primary.copy(alpha = 0.5f),
                errorCursorColor = MaterialTheme.tqColorsPalette.primary,
                cursorColor = MaterialTheme.tqColorsPalette.contentTertiary,
            ),
        )

        AnimatedVisibility(isError) {
            Text(
                text = errorMessage,
                modifier = Modifier.padding(top = MaterialTheme.tqDimens.space8),
                style = MaterialTheme.tqTypography.labelSmall,
                color = MaterialTheme.tqColorsPalette.primary
            )
        }
    }
}
@Composable
private fun ContainerColor(isError: Boolean, correctValidation: Boolean): Color {
    return if (isError) {
        MaterialTheme.tqColorsPalette.hover
    } else if (correctValidation) {
        MaterialTheme.tqColorsPalette.successContainer
    } else {
        MaterialTheme.tqColorsPalette.surface
    }
}
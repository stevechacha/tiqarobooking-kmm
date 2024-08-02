package presentation.common.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import presentation.common.theme.tqColorsPalette
import presentation.common.theme.tqDimens
import presentation.common.theme.tqRadius
import presentation.common.theme.tqTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TqExpandableTextField(
    label: String,
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    shapeRadius: Shape = RoundedCornerShape(MaterialTheme.tqRadius.medium),
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
            modifier = Modifier.fillMaxWidth().heightIn(min = 104.dp, max = 160.dp),
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
            singleLine = false,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = MaterialTheme.tqColorsPalette.surface,
                unfocusedBorderColor = MaterialTheme.tqColorsPalette.divider.copy(alpha = 0.1f),
                focusedBorderColor = MaterialTheme.tqColorsPalette.contentTertiary.copy(alpha = 0.2f),
                cursorColor = MaterialTheme.tqColorsPalette.contentTertiary,
            ),
        )
    }
}

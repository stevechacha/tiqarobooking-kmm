package presentation.common.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import tiqarobooking.composeapp.generated.resources.Res
import tiqarobooking.composeapp.generated.resources.Roboto_Bold

@Composable
fun displayLarge(): TextStyle {
    return TextStyle(
        fontSize = 34.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))

    )
}

@Composable
fun displayMedium(): TextStyle {
    return TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))
    )
}

@Composable
fun displaySmall(): TextStyle {
    return TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))
    )
}

@Composable
fun headlineLarge(): TextStyle {
    return TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))
    )
}

@Composable
fun headlineMedium(): TextStyle {
    return TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))
    )
}

@Composable
fun headlineSmall(): TextStyle {
    return TextStyle(
        fontSize = 8.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))
    )
}

@Composable
fun titleLarge(): TextStyle {
    return TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))
    )
}

@Composable
fun titleMedium(): TextStyle {
    return TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))
    )
}

@Composable
fun titleSmall ():TextStyle{
    return TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))
    )
}

@Composable
fun bodyLarge(): TextStyle {
    return TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))
    )
}

@Composable
fun bodyMedium(): TextStyle {
    return TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))
    )
}

@Composable
fun bodySmall(): TextStyle {
    return TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))
    )
}

@Composable
fun labelLarge(): TextStyle {
    return TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))
    )
}

@Composable
fun labelMedium(): TextStyle {
    return TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))
    )
}

@Composable
fun labelSmall(): TextStyle {
    return TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily(Font(Res.font.Roboto_Bold))
    )
}

package presentation.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val localColorScheme = staticCompositionLocalOf { LightColorScheme }
private val localDimens = staticCompositionLocalOf { Dimens() }
private val localRadius = staticCompositionLocalOf { Radius() }
private val localTypography = staticCompositionLocalOf { AppTypography() }

@Composable
fun TqTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (useDarkTheme) DarkColorScheme else LightColorScheme

    val typography = AppTypography(
        displayLarge = displayLarge(),
        displayMedium = displayMedium(),
        displaySmall = displaySmall(),
        headlineLarge = headlineLarge(),
        headlineMedium = headlineMedium(),
        headlineSmall = headlineSmall(),
        titleLarge = titleLarge(),
        titleMedium = titleMedium(),
        titleSmall = titleSmall(),
        bodyLarge = bodyLarge(),
        bodyMedium = bodyMedium(),
        bodySmall = bodySmall(),
        labelLarge = labelLarge(),
        labelMedium = labelMedium(),
        labelSmall = labelSmall(),
    )


    CompositionLocalProvider(
        localColorScheme provides colorScheme,
        localDimens provides Dimens(),
        localRadius provides Radius(),
        localTypography provides typography,
    ) {
        MaterialTheme(
            content = content,
        )
    }
}

val MaterialTheme.tqColorsPalette: TqColors
    @Composable
    @ReadOnlyComposable
    get() = localColorScheme.current

val MaterialTheme.tqDimens: Dimens
    @Composable
    @ReadOnlyComposable
    get() = localDimens.current

val MaterialTheme.tqRadius: Radius
    @Composable
    @ReadOnlyComposable
    get() = localRadius.current

val MaterialTheme.tqTypography: AppTypography
    @Composable
    @ReadOnlyComposable
    get() = localTypography.current


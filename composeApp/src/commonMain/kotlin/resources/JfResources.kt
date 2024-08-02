package resources

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalLayoutDirection
import presentation.common.theme.TqTheme
import resources.strings.IStringResources
import util.LanguageCode
import util.LocalizationManager
import util.setInsetsController


private val localStringResources = staticCompositionLocalOf<IStringResources> {
    error("CompositionLocal IStringResources not present")
}
private val localTqDrawableResources = staticCompositionLocalOf { JofaHotelDrawableResources() }

@Composable
fun TqBookingTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    languageCode: LanguageCode = LanguageCode.EN,
    content: @Composable () -> Unit
) {
    val drawableResources =
        if (useDarkTheme) JofaHotelDrawableDarkResources else JofaHotelDrawableResources()
    CompositionLocalProvider(
        localStringResources provides LocalizationManager.getStringResources(languageCode),
        localTqDrawableResources provides drawableResources,
        LocalLayoutDirection provides LocalizationManager.getLayoutDirection(languageCode)
    ) {
        TqTheme(useDarkTheme = useDarkTheme) {
            setInsetsController(useDarkTheme)
            content()
        }
    }
}

object Resources {
    val strings: IStringResources
        @Composable
        get() = localStringResources.current

    val images: JofaHotelDrawableResources
        @Composable
        get() = localTqDrawableResources.current
}

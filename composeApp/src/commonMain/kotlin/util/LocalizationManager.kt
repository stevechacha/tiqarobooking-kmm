package util

import androidx.compose.ui.unit.LayoutDirection
import resources.strings.IStringResources
import resources.strings.en.English
import resources.strings.sw.Swahili


object LocalizationManager {
    fun getStringResources(languageCode: LanguageCode): IStringResources {
        return when (languageCode) {
            LanguageCode.EN -> English()
            LanguageCode.SW -> Swahili()

        }
    }

    fun getLayoutDirection(languageCode: LanguageCode): LayoutDirection {
        return when (languageCode) {
            LanguageCode.EN -> LayoutDirection.Ltr
            LanguageCode.SW -> LayoutDirection.Ltr
            else -> LayoutDirection.Rtl
        }
    }
}

package util

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
expect fun setInsetsController(isDark: Boolean)

@Composable
expect fun getStatusBarPadding(): PaddingValues

@Composable
expect fun getNavigationBarPadding(): PaddingValues

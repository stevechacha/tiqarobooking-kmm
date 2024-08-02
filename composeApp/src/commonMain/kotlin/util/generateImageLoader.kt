package util

import androidx.compose.runtime.Composable
import com.seiko.imageloader.ImageLoader
import io.ktor.client.engine.HttpClientEngine
import org.koin.core.module.Module


@Composable
expect fun generateImageLoader(applicationContext: PlatformContext): ImageLoader

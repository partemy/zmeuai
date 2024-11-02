package dev.partemy.zmeuai.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.backgroundDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.backgroundLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.errorContainerDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.errorContainerLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.errorDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.errorLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.inverseOnSurfaceDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.inverseOnSurfaceLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.inversePrimaryDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.inversePrimaryLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.inverseSurfaceDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.inverseSurfaceLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onBackgroundDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onBackgroundLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onErrorContainerDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onErrorContainerLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onErrorDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onErrorLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onPrimaryContainerDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onPrimaryContainerLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onPrimaryDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onPrimaryLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onSecondaryContainerDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onSecondaryContainerLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onSecondaryDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onSecondaryLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onSurfaceDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onSurfaceLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onSurfaceVariantDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onSurfaceVariantLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onTertiaryContainerDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onTertiaryContainerLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onTertiaryDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.onTertiaryLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.outlineDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.outlineLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.outlineVariantDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.outlineVariantLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.primaryContainerDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.primaryContainerLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.primaryDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.primaryLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.scrimDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.scrimLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.secondaryContainerDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.secondaryContainerLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.secondaryDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.secondaryLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceBrightDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceBrightLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceContainerDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceContainerHighDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceContainerHighLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceContainerHighestDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceContainerHighestLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceContainerLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceContainerLowDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceContainerLowLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceContainerLowestDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceContainerLowestLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceDimDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceDimLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceVariantDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.surfaceVariantLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.tertiaryContainerDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.tertiaryContainerLight
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.tertiaryDark
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiColors.tertiaryLight

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

@Composable
fun ZmeuaiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
  val colorScheme = if (darkTheme) darkScheme else lightScheme

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography.typography,
      shapes = shapes,
    content = content
  )
}


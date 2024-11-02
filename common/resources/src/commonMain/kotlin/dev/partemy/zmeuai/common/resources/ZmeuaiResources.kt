package dev.partemy.zmeuai.common.resources

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import cafe.adriel.lyricist.LocalStrings

object ZmeuaiResources {
    val strings: ZmeuaiStrings
    @Composable
    @ReadOnlyComposable
    get() = LocalStrings.current
}
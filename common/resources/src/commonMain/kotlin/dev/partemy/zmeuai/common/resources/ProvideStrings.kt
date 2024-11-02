package dev.partemy.zmeuai.common.resources

import androidx.compose.runtime.Composable
import cafe.adriel.lyricist.LocalStrings
import cafe.adriel.lyricist.Lyricist
import cafe.adriel.lyricist.ProvideStrings
import cafe.adriel.lyricist.rememberStrings

internal val ZmeuaiAppStrings: Map<String, ZmeuaiStrings> = mapOf(
    Locales.EN to EnStrings,
    Locales.RU to RuStrings,
)

@Composable
internal fun rememberZmeuaiStrings(): Lyricist<ZmeuaiStrings> =
    rememberStrings(ZmeuaiAppStrings)

@Composable
fun ProvideZmeuaiStrings(
    content: @Composable () -> Unit
) {
    ProvideStrings(rememberZmeuaiStrings(), LocalStrings, content)
}
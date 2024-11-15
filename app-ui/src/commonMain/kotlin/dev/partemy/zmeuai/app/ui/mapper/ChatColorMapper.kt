package dev.partemy.zmeuai.app.ui.mapper

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import dev.partemy.zmeuai.common.domain.model.ChatItemType

@Composable
fun MaterialTheme.chatColorOf(chatItemType: ChatItemType) =
    when (chatItemType) {
        ChatItemType.USER -> colorScheme.primary
        ChatItemType.TEXT -> colorScheme.onSurface
        ChatItemType.IMAGE -> colorScheme.onSurface
    }
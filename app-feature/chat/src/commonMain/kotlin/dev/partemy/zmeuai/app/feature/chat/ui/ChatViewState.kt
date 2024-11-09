package dev.partemy.zmeuai.app.feature.chat.ui

import androidx.compose.runtime.Stable
import dev.partemy.zmeuai.app.ui.base.IViewState
import dev.partemy.zmeuai.common.domain.model.ChatItem

@Stable
data class ChatViewState(
    val chat: List<ChatItem> = emptyList()
) : IViewState
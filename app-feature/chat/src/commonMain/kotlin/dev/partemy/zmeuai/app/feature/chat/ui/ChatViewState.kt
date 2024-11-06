package dev.partemy.zmeuai.app.feature.chat.ui

import dev.partemy.zmeuai.app.ui.base.IViewState

data class ChatViewState(
    val text: String = "",
) : IViewState
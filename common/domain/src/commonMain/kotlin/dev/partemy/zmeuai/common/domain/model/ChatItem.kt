package dev.partemy.zmeuai.common.domain.model


data class ChatItem(
    val chatID: Long,
    val text: String,
    val type: ChatItemType,
)

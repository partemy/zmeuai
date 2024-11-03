package dev.partemy.zmeuai.common.domain.model


data class ChatItem(
    val id: String,
    val name: String,
    val text: String,
    val type: ChatItemType,
)

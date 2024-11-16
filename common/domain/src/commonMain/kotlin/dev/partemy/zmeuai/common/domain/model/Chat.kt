package dev.partemy.zmeuai.common.domain.model

data class Chat(
    val chatID: Long,
    val title: String,
    val text: String,
    val creationTime: Long,
)

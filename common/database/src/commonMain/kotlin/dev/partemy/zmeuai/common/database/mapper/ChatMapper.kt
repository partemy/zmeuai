package dev.partemy.zmeuai.common.database.mapper

import dev.partemy.zmeuai.common.database.entity.ChatEntity
import dev.partemy.zmeuai.common.domain.model.Chat

fun ChatEntity.toChat() = Chat(
    chatID = chatId,
    title = title ?: "",
    text = text ?: "",
    creationTime = creationTime
)

fun Chat.toChatEntity() = ChatEntity(
    title = title,
    text = text,
    creationTime = creationTime
)
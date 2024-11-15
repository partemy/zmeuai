package dev.partemy.zmeuai.common.database.mapper

import dev.partemy.zmeuai.common.database.entity.ChatItemEntity
import dev.partemy.zmeuai.common.domain.model.ChatItem
import dev.partemy.zmeuai.common.domain.model.ChatItemType

fun ChatItem.toChatItemEntity() = ChatItemEntity(
    chatID = chatID,
    type = type.name,
    message = text,
)

fun ChatItemEntity.toChatItem() = ChatItem(
    chatID = chatID,
    type = ChatItemType.valueOf(type),
    text = message,
)
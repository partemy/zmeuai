package dev.partemy.zmeuai.common.data.remote.mapper

import dev.partemy.zmeuai.common.data.remote.model.ChatDTO
import dev.partemy.zmeuai.common.data.remote.model.History
import dev.partemy.zmeuai.common.domain.model.ChatItem
import dev.partemy.zmeuai.common.domain.model.ChatItemType

fun History.toChatItem(chatID: Long) = ChatItem(
    chatID = chatID,
    type = ChatItemType.valueOf(role),
    text = parts,
)

fun ChatItem.toHistory() = History(
    role = type.role,
    parts = text,
)
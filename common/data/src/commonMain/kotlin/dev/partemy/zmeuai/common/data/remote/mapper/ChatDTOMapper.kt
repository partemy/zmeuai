package dev.partemy.zmeuai.common.data.remote.mapper

import dev.partemy.zmeuai.common.data.remote.model.History
import dev.partemy.zmeuai.common.domain.model.ChatItem

fun ChatItem.toHistory() = History(
    role = type.role,
    parts = text,
)
package dev.partemy.zmeuai.common.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import dev.partemy.zmeuai.common.database.entity.ChatEntity
import dev.partemy.zmeuai.common.database.entity.ChatItemEntity

data class ChatWithMessages(
    @Embedded val chat: ChatEntity,
    @Relation(
        parentColumn = "chatId",
        entityColumn = "chatId"
    )
    val messages: List<ChatItemEntity>
)
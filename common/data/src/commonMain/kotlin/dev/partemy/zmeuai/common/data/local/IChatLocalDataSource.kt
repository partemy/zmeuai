package dev.partemy.zmeuai.common.data.local

import dev.partemy.zmeuai.common.database.entity.ChatItemEntity
import dev.partemy.zmeuai.common.domain.model.ChatItem
import kotlinx.coroutines.flow.Flow

interface IChatLocalDataSource {
    fun getChatItemsByChatID(chatID: Long): Flow<List<ChatItem>>
    suspend fun addChatItem(item: ChatItemEntity)
    suspend fun editChatTitle(text: String, id: Long)
    suspend fun editChatText(text: String, id: Long)
}
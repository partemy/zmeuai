package dev.partemy.zmeuai.common.data.local

import dev.partemy.zmeuai.common.domain.model.ChatItem
import kotlinx.coroutines.flow.Flow

interface IChatLocalDataSource {
    fun getChatItems(): Flow<List<ChatItem>>

    suspend fun addChatItem(item: ChatItem)
}
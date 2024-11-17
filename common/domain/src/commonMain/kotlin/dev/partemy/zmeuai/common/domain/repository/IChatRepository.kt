package dev.partemy.zmeuai.common.domain.repository

import dev.partemy.zmeuai.common.domain.model.ChatItem
import kotlinx.coroutines.flow.Flow

interface IChatRepository {
    fun getChat(chatID: Long): Flow<List<ChatItem>>
    suspend fun generate(message: String, chatID: Long)
}
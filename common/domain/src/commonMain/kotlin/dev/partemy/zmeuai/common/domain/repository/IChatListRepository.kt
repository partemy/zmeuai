package dev.partemy.zmeuai.common.domain.repository

import dev.partemy.zmeuai.common.domain.model.Chat
import kotlinx.coroutines.flow.Flow

interface IChatListRepository {
    fun getChats(): Flow<List<Chat>>
    suspend fun addChat()
    suspend fun getLastChatId(): Long?
}
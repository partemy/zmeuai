package dev.partemy.zmeuai.common.data.local

import dev.partemy.zmeuai.common.domain.model.Chat
import kotlinx.coroutines.flow.Flow

interface IChatListLocalDataSource {
    fun getAllChats() : Flow<List<Chat>>
    suspend fun addNewChat(chat: Chat)
    suspend fun getLastChat(): Chat?
}
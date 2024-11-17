package dev.partemy.zmeuai.common.data.local

import dev.partemy.zmeuai.common.database.dao.ChatDao
import dev.partemy.zmeuai.common.database.mapper.toChat
import dev.partemy.zmeuai.common.database.mapper.toChatEntity
import dev.partemy.zmeuai.common.domain.model.Chat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChatListLocalDataSource(
    private val chatDao: ChatDao,
) : IChatListLocalDataSource {

    override fun getAllChats(): Flow<List<Chat>> {
        return chatDao.getAllChats().map { chatEntities -> chatEntities.map { it.toChat() } }
    }

    override suspend fun addNewChat(chat: Chat) {
        chatDao.addChat(chat = chat.toChatEntity())
    }

    override suspend fun getLastChat(): Chat? =
        chatDao.getLastChat()?.toChat()

}


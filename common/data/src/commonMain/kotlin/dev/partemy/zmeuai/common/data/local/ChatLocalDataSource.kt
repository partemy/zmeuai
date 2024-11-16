package dev.partemy.zmeuai.common.data.local

import dev.partemy.zmeuai.common.database.ZmeuaiDatabase
import dev.partemy.zmeuai.common.database.dao.ChatDao
import dev.partemy.zmeuai.common.database.mapper.toChatItem
import dev.partemy.zmeuai.common.database.mapper.toChatItemEntity
import dev.partemy.zmeuai.common.domain.model.ChatItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChatLocalDataSource(
    private val chatDao: ChatDao,
) : IChatLocalDataSource {
    override fun getChatItems(): Flow<List<ChatItem>> {
        return chatDao.getAllAsFlow().map { list -> list.map { it.toChatItem() } }
    }

    override suspend fun addChatItem(item: ChatItem) {
        chatDao.insert(item.toChatItemEntity())
    }

    override suspend fun getLastMessageID(chatID: Long): Long {
        return chatDao.getLastMessageID(chatID)
    }

}
package dev.partemy.zmeuai.common.data.local

import dev.partemy.zmeuai.common.database.dao.ChatDao
import dev.partemy.zmeuai.common.database.entity.ChatItemEntity
import dev.partemy.zmeuai.common.database.mapper.toChatItem
import dev.partemy.zmeuai.common.domain.model.ChatItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChatLocalDataSource(
    private val chatDao: ChatDao,
) : IChatLocalDataSource {

    override fun getChatItemsByChatID(chatID: Long): Flow<List<ChatItem>> {
        return chatDao.getChatWithMessages(chatID)
            .map { chatEntities -> chatEntities.messages.map { it.toChatItem() } }
    }

    override suspend fun addChatItem(item: ChatItemEntity) {
        chatDao.addChatItem(item)
    }

    override suspend fun editChatTitle(text: String, id: Long) {
        chatDao.updateTitle(title = text, id = id)
    }

    override suspend fun editChatText(text: String, id: Long) {
        chatDao.updateChatPreviewText(text = text, id = id)
    }
}
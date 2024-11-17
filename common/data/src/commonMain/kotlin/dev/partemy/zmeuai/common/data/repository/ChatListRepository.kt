package dev.partemy.zmeuai.common.data.repository

import dev.partemy.zmeuai.common.data.local.IChatListLocalDataSource
import dev.partemy.zmeuai.common.domain.model.Chat
import dev.partemy.zmeuai.common.domain.repository.IChatListRepository
import kotlinx.coroutines.flow.Flow

class ChatListRepository(
    private val chatListLocalDataSource: IChatListLocalDataSource
) : IChatListRepository {
    override fun getChats(): Flow<List<Chat>> {
        return chatListLocalDataSource.getAllChats()
    }

    override suspend fun addChat() {
        val lastChatTitle = chatListLocalDataSource.getLastChat()?.title
        if (lastChatTitle == null || lastChatTitle.isNotBlank())
            chatListLocalDataSource.addNewChat(
                Chat(
                    chatID = 0,
                    title = "",
                    text = "",
                    creationTime = 288
                )
            )
    }

    override suspend fun getLastChatId(): Long? =
        chatListLocalDataSource.getLastChat()?.chatID
}
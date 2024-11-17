package dev.partemy.zmeuai.common.data.repository

import dev.partemy.zmeuai.common.data.local.IChatLocalDataSource
import dev.partemy.zmeuai.common.data.remote.api.ChatApi
import dev.partemy.zmeuai.common.data.remote.mapper.toHistory
import dev.partemy.zmeuai.common.data.remote.model.ChatDTO
import dev.partemy.zmeuai.common.database.entity.ChatItemEntity
import dev.partemy.zmeuai.common.domain.ResultState
import dev.partemy.zmeuai.common.domain.model.ChatItem
import dev.partemy.zmeuai.common.domain.model.ChatItemType
import dev.partemy.zmeuai.common.domain.repository.IChatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class ChatRepository(
    private val chatApi: ChatApi,
    private val chatLocalDataSource: IChatLocalDataSource,
) : IChatRepository {

    override fun getChat(chatID: Long): Flow<List<ChatItem>> {
        return chatLocalDataSource.getChatItemsByChatID(chatID)
    }

    override suspend fun generate(message: String, chatID: Long) {
        val chat = getChat(chatID).first()
        val isFirstMessage = chat.isEmpty()
        if (isFirstMessage) chatLocalDataSource.editChatTitle(message, id = chatID)
        addMessageToLocalSource(chatID, message, ChatItemType.USER)
        getMessageFromApi(chat, message).collect { result ->
            when (result) {
                is ResultState.Success -> {
                    addMessageToLocalSource(chatID, result.data, ChatItemType.TEXT)
                    if (isFirstMessage) chatLocalDataSource.editChatText(result.data, id = chatID)
                }

                is ResultState.Failure ->
                    addMessageToLocalSource(chatID, result.exception.toString(), ChatItemType.TEXT)

                is ResultState.Loading -> {}

            }
        }
    }

    private suspend fun getMessageFromApi(
        chatItems: List<ChatItem>,
        message: String
    ): Flow<ResultState<String>> {
        return chatApi.getMessage(
            ChatDTO(
                history = chatItems.map { it.toHistory() },
                new_message = message
            )
        )
    }

    private suspend fun addMessageToLocalSource(
        chatID: Long,
        text: String,
        type: ChatItemType,
    ) {
        chatLocalDataSource.addChatItem(
            ChatItemEntity(
                chatId = chatID,
                type = type.name,
                message = text
            )
        )
    }

}
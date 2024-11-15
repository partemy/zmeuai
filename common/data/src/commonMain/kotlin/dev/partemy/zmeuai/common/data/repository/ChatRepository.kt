package dev.partemy.zmeuai.common.data.repository

import dev.partemy.zmeuai.common.data.local.IChatLocalDataSource
import dev.partemy.zmeuai.common.data.remote.api.ChatApi
import dev.partemy.zmeuai.common.data.remote.mapper.toHistory
import dev.partemy.zmeuai.common.data.remote.model.ChatDTO
import dev.partemy.zmeuai.common.data.remote.model.History
import dev.partemy.zmeuai.common.domain.ResultState
import dev.partemy.zmeuai.common.domain.model.ChatItem
import dev.partemy.zmeuai.common.domain.model.ChatItemType
import dev.partemy.zmeuai.common.domain.repository.IChatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.take

class ChatRepository(
    private val chatApi: ChatApi,
    private val chatLocalDataSource: IChatLocalDataSource,
) : IChatRepository {

    override suspend fun generate(message: String) {

        chatLocalDataSource.addChatItem(item = ChatItem(chatID = 0, type = ChatItemType.USER, text = message))
        val chat = getChat().first()
        getMessageFromApi(chat, message).collect { result ->
            when (result) {
                is ResultState.Success -> {
                    chatLocalDataSource.addChatItem(item = ChatItem(chatID = 0, type = ChatItemType.TEXT, text = result.data))
                }
                is ResultState.Failure -> {
                    chatLocalDataSource.addChatItem(item = ChatItem(chatID = 0, type = ChatItemType.TEXT, text = result.exception.toString()))
                }
                is ResultState.Loading -> {
                    chatLocalDataSource.addChatItem(item = ChatItem(chatID = 0, type = ChatItemType.TEXT, text = "Loading"))
                }
            }
        }
    }

    override fun getChat(): Flow<List<ChatItem>> {
        return chatLocalDataSource.getChatItems()
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

}
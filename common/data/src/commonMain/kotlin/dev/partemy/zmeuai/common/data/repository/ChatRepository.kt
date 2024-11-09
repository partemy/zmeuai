package dev.partemy.zmeuai.common.data.repository

import dev.partemy.zmeuai.common.data.remote.api.ChatApi
import dev.partemy.zmeuai.common.data.remote.model.ChatDTO
import dev.partemy.zmeuai.common.data.remote.model.History
import dev.partemy.zmeuai.common.domain.ResultState
import dev.partemy.zmeuai.common.domain.model.ChatItem
import dev.partemy.zmeuai.common.domain.repository.IChatRepository
import kotlinx.coroutines.flow.Flow

class ChatRepository(
    private val chatApi: ChatApi
) : IChatRepository {
    override suspend fun getMessage(
        list: List<ChatItem>,
        message: String
    ): Flow<ResultState<String>> {
        return chatApi.getMessage(ChatDTO(history = list.map {
            History(
                parts = it.text,
                role = it.type.role
            )
        }, new_message = message)) //TODO add map
    }

}
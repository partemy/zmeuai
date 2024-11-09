package dev.partemy.zmeuai.common.domain.repository

import dev.partemy.zmeuai.common.domain.ResultState
import dev.partemy.zmeuai.common.domain.model.ChatItem
import kotlinx.coroutines.flow.Flow

interface IChatRepository {
    suspend fun getMessage(list: List<ChatItem>, message: String) : Flow<ResultState<String>>
}
package dev.partemy.zmeuai.common.domain.repository

import dev.partemy.zmeuai.common.domain.ResultState
import dev.partemy.zmeuai.common.domain.model.ChatItem
import kotlinx.coroutines.flow.Flow

interface IChatRepository {
    suspend fun generate(message: String, chatID: Long)
    fun getChat(): Flow<List<ChatItem>>
}
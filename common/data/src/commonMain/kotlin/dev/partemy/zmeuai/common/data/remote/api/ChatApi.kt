package dev.partemy.zmeuai.common.data.remote.api

import dev.partemy.zmeuai.common.data.remote.apiCall
import dev.partemy.zmeuai.common.data.remote.model.ChatDTO
import dev.partemy.zmeuai.common.domain.ResultState
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface ChatApi {
    suspend fun getMessage(param: ChatDTO): Flow<ResultState<String>>
}
package dev.partemy.zmeuai.common.data.remote.api.impl

import dev.partemy.zmeuai.common.data.remote.api.ChatApi
import dev.partemy.zmeuai.common.data.remote.apiCall
import dev.partemy.zmeuai.common.data.remote.model.ChatDTO
import dev.partemy.zmeuai.common.domain.ResultState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ChatApiImpl(private val httpClient: HttpClient) : ChatApi {
    override suspend fun getMessage(param: ChatDTO): Flow<ResultState<String>> {
        return flowOf(
            apiCall {
                httpClient.post(urlString = "/generate/text") {
                    setBody(param)
                }.body<String>()
            }
        )
    }
}
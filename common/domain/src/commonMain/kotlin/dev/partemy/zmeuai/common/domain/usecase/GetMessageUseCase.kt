package dev.partemy.zmeuai.common.domain.usecase

import dev.partemy.zmeuai.common.domain.model.ChatItem
import dev.partemy.zmeuai.common.domain.repository.IChatRepository

class GetMessageUseCase(
    private val chatRepository: IChatRepository
) {
    suspend operator fun invoke(chat: List<ChatItem>, message: String) =
        chatRepository.getMessage(list = chat, message = message)
}
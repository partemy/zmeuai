package dev.partemy.zmeuai.common.domain.usecase

import dev.partemy.zmeuai.common.domain.model.Chat
import dev.partemy.zmeuai.common.domain.repository.IChatListRepository

class AddChatUseCase(
    private val chatListRepository: IChatListRepository,
) {
    suspend operator fun invoke() = chatListRepository.addChat()
}
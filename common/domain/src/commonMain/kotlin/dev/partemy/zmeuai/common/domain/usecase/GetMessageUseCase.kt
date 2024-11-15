package dev.partemy.zmeuai.common.domain.usecase

import dev.partemy.zmeuai.common.domain.model.ChatItem
import dev.partemy.zmeuai.common.domain.repository.IChatRepository

class GetMessageUseCase(
    private val chatRepository: IChatRepository
) {
    operator fun invoke() =
        chatRepository.getChat()
}
package dev.partemy.zmeuai.common.domain.usecase

import dev.partemy.zmeuai.common.domain.repository.IChatRepository

class GenerateMessageUseCase(
    private val chatRepository: IChatRepository,
) {
    suspend operator fun invoke(message: String, chatID: Long) =
        chatRepository.generate(message , chatID = chatID)

}
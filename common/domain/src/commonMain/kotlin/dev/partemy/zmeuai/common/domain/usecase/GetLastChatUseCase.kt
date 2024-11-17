package dev.partemy.zmeuai.common.domain.usecase

import dev.partemy.zmeuai.common.domain.repository.IChatListRepository

class GetLastChatUseCase(
    private val chatListRepository: IChatListRepository,
) {
    suspend operator fun invoke(): Long? = chatListRepository.getLastChatId()
}
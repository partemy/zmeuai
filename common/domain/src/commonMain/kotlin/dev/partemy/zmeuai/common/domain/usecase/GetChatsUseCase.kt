package dev.partemy.zmeuai.common.domain.usecase

import dev.partemy.zmeuai.common.domain.repository.IChatListRepository

class GetChatsUseCase(
    private val chatListRepository: IChatListRepository,
) {
    operator fun invoke() = chatListRepository.getChats()
}
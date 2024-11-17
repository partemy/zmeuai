package dev.partemy.zmeuai.common.core

import dev.partemy.zmeuai.common.domain.usecase.AddChatUseCase
import dev.partemy.zmeuai.common.domain.usecase.GenerateMessageUseCase
import dev.partemy.zmeuai.common.domain.usecase.GetChatsUseCase
import dev.partemy.zmeuai.common.domain.usecase.GetLastChatUseCase
import dev.partemy.zmeuai.common.domain.usecase.GetMessageUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val useCaseModule = module {
    singleOf(::GetMessageUseCase)
    singleOf(::GenerateMessageUseCase)
    singleOf(::GetChatsUseCase)
    singleOf(::AddChatUseCase)
    singleOf(::GetLastChatUseCase)
}
package dev.partemy.zmeuai.common.core

import dev.partemy.zmeuai.common.data.repository.ChatListRepository
import dev.partemy.zmeuai.common.data.repository.ChatRepository
import dev.partemy.zmeuai.common.domain.repository.IChatListRepository
import dev.partemy.zmeuai.common.domain.repository.IChatRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val repositoryModule = module {
    singleOf(::ChatRepository) bind IChatRepository::class
    singleOf(::ChatListRepository) bind IChatListRepository::class
}
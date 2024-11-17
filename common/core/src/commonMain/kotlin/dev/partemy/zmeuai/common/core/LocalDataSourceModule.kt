package dev.partemy.zmeuai.common.core

import dev.partemy.zmeuai.common.data.local.ChatListLocalDataSource
import dev.partemy.zmeuai.common.data.local.IChatLocalDataSource
import dev.partemy.zmeuai.common.data.local.ChatLocalDataSource
import dev.partemy.zmeuai.common.data.local.IChatListLocalDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val localDataSourceModule = module {
    single<IChatLocalDataSource> { ChatLocalDataSource(get()) }
    single<IChatListLocalDataSource> { ChatListLocalDataSource(get()) }
}
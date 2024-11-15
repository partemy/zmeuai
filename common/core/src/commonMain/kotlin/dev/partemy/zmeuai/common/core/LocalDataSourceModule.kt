package dev.partemy.zmeuai.common.core

import dev.partemy.zmeuai.common.data.local.IChatLocalDataSource
import dev.partemy.zmeuai.common.data.local.ChatLocalDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val localDataSourceModule = module {
    single<IChatLocalDataSource> { ChatLocalDataSource(get()) }
}
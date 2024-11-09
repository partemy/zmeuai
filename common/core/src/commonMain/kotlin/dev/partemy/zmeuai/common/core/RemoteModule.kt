package dev.partemy.zmeuai.common.core

import dev.partemy.zmeuai.common.data.remote.api.ChatApi
import dev.partemy.zmeuai.common.data.remote.api.impl.ChatApiImpl
import dev.partemy.zmeuai.common.data.remote.createHttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteModule = module {
    single { createHttpClient() }
    singleOf(::ChatApiImpl).bind(ChatApi::class)
}
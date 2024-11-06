package dev.partemy.zmeuai.app.feature.chat.di

import dev.partemy.zmeuai.app.feature.chat.ui.ChatViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val chatViewModelModule = module {
    factoryOf(::ChatViewModel)
}
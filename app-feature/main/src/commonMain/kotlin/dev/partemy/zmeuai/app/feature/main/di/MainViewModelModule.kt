package dev.partemy.zmeuai.app.feature.main.di

import dev.partemy.zmeuai.app.feature.main.ui.MainViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val mainViewModelModule = module {
    factoryOf(::MainViewModel)
}
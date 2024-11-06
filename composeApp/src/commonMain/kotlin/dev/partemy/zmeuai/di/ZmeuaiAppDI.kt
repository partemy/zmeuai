package dev.partemy.zmeuai.di

import androidx.compose.runtime.Composable
import org.koin.compose.KoinApplication
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

import org.koin.dsl.KoinAppDeclaration

fun zmeuaiAppDI(
    appDeclaration: KoinAppDeclaration? = null
) = startKoin {
    appDeclaration?.invoke(this)
    modules(presentationModules)
}
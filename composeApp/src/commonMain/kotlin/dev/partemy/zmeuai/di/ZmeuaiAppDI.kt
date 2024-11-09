package dev.partemy.zmeuai.di

import androidx.compose.runtime.Composable
import dev.partemy.zmeuai.common.core.dataModules
import dev.partemy.zmeuai.common.core.domainModules
import org.koin.compose.KoinApplication
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

import org.koin.dsl.KoinAppDeclaration

fun zmeuaiAppDI(
    appDeclaration: KoinAppDeclaration? = null
) = startKoin {
    appDeclaration?.invoke(this)
    modules(presentationModules + dataModules + domainModules)
}

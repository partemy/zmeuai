package dev.partemy.zmeuai.di

import dev.partemy.zmeuai.app.feature.chat.di.chatViewModelModule
import dev.partemy.zmeuai.app.feature.main.di.mainViewModelModule

val presentationModules = chatViewModelModule + mainViewModelModule
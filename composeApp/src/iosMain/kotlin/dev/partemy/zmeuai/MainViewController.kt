package dev.partemy.zmeuai

import androidx.compose.ui.window.ComposeUIViewController
import dev.partemy.zmeuai.app.feature.chat.ui.ChatScreen
import dev.partemy.zmeuai.di.zmeuaiAppDI


fun MainViewController() = ComposeUIViewController(configure = { zmeuaiAppDI() }) { ZmeuaiApp() }
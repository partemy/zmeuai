package dev.partemy.zmeuai

import androidx.compose.ui.window.ComposeUIViewController
import dev.partemy.zmeuai.app.feature.chat.ChatScreen


fun MainViewController() = ComposeUIViewController { ChatScreen() }
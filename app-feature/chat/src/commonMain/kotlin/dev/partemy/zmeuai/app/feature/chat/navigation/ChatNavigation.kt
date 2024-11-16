package dev.partemy.zmeuai.app.feature.chat.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import dev.partemy.zmeuai.app.feature.chat.ui.ChatScreen
import kotlinx.serialization.Serializable
import org.koin.compose.koinInject

@Serializable
data class ChatRoute(
    val chatID: Long
)

fun NavController.navigateToChat(
    chatID: Long,
    navOptions: NavOptions? = null
) {
    this.navigate(ChatRoute(chatID = chatID), navOptions)
}

fun NavGraphBuilder.chatScreen(
    navigateBack: () -> Unit,
) {
    composable<ChatRoute> {
        ChatScreen(viewModel = koinInject())
    }
}



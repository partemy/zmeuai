package dev.partemy.zmeuai.app.feature.chat.navigation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import dev.partemy.zmeuai.app.feature.chat.ui.ChatScreen
import kotlinx.serialization.Serializable
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

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
    composable<ChatRoute> { backStackEntry ->
        val chat: ChatRoute = backStackEntry.toRoute()
        ChatScreen(viewModel = koinInject { parametersOf(chat.chatID) })
    }
}


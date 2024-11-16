package dev.partemy.zmeuai.app.feature.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import dev.partemy.zmeuai.app.feature.main.ui.MainScreen
import kotlinx.serialization.Serializable
import org.koin.compose.koinInject

@Serializable
object MainRoute

fun NavController.navigateToMain(
    navOptions: NavOptions? = null
) {
    this.navigate(MainRoute, navOptions)
}

fun NavGraphBuilder.mainScreen(
    navigateToChat: (Long) -> Unit,
) {
    composable<MainRoute> {
        MainScreen(
            viewModel = koinInject(),
            navigateToChat = navigateToChat
        )
    }
}
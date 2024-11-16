package dev.partemy.zmeuai.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.partemy.zmeuai.app.feature.chat.navigation.chatScreen
import dev.partemy.zmeuai.app.feature.chat.navigation.navigateToChat
import dev.partemy.zmeuai.app.feature.main.navigation.MainRoute
import dev.partemy.zmeuai.app.feature.main.navigation.mainScreen

@Composable
fun ZmeuaiNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = MainRoute,
    ) {
        mainScreen(navigateToChat = { navController.navigateToChat(it) })
        chatScreen(navigateBack = { navController.popBackStack() })
    }

}
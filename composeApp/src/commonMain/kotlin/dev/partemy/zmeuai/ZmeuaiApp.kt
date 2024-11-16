package dev.partemy.zmeuai

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiTheme
import dev.partemy.zmeuai.common.resources.ProvideZmeuaiStrings
import dev.partemy.zmeuai.navhost.ZmeuaiNavHost

@Composable
fun ZmeuaiApp() {
    val navController = rememberNavController()
    ProvideZmeuaiStrings {
        ZmeuaiTheme {
            ZmeuaiNavHost(navController = navController)
        }
    }
}
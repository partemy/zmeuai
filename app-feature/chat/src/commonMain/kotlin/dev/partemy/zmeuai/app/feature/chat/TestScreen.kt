package dev.partemy.zmeuai.app.feature.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiTheme
import dev.partemy.zmeuai.common.resources.ProvideZmeuaiStrings
import dev.partemy.zmeuai.common.resources.ZmeuaiResources
import org.jetbrains.compose.resources.vectorResource
import zmeuai.common.resources.generated.resources.Res
import zmeuai.common.resources.generated.resources.aroow_right1

@Composable
fun TestScreen(modifier: Modifier = Modifier) {
    ProvideZmeuaiStrings {
        ZmeuaiTheme {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    ZmeuaiResources.strings.text,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Icon(vectorResource(Res.drawable.aroow_right1), contentDescription = null)
            }
        }
    }

}
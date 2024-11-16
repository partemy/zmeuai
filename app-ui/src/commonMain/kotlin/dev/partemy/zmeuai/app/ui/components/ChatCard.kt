package dev.partemy.zmeuai.app.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ChatCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    title: String,
    text: String,
    time: String,
) {
    val titleColor = MaterialTheme.colorScheme.primary
    val textColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f)
    val timeColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f)
    val shape = MaterialTheme.shapes.small
    Box(
        modifier = modifier
            .clip(shape)
            .border(width = 1.dp, color = timeColor, shape = shape)
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                color = titleColor,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                color = textColor,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = time, color = timeColor, style = MaterialTheme.typography.bodySmall)
        }
    }
}
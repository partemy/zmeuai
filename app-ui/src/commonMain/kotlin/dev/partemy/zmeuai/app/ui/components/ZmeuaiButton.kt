package dev.partemy.zmeuai.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.partemy.zmeuai.app.ui.values.SmallPadding
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun ZmeuaiButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    isActive: Boolean = false,
    icon: DrawableResource? = null,
) {
    val buttonColor =
        if (isActive) MaterialTheme.colorScheme.onSurface else Color.Transparent
    val outlineColor =
        if (isActive) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.surfaceVariant.copy(
            alpha = 0.4f
        )
    val textColor =
        if (isActive) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.onSurface.copy(
            alpha = 0.6f
        )
    val iconColor =
        if (isActive) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.onBackground
    OutlinedButton(
        modifier = Modifier,
        colors = ButtonDefaults.outlinedButtonColors(containerColor = buttonColor),
        border = BorderStroke(width = 0.5.dp, color = outlineColor),
        onClick = onClick,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 2.dp)
        ) {
            if (icon != null) {
                Icon(
                    imageVector = vectorResource(icon),
                    null,
                    tint = iconColor,
                    modifier = Modifier.size(24.dp),
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(text, color = textColor, style = MaterialTheme.typography.labelMedium)
        }
    }
}


package dev.partemy.zmeuai.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import dev.partemy.zmeuai.app.ui.mapper.chatColorOf
import dev.partemy.zmeuai.app.ui.values.SectionPadding
import dev.partemy.zmeuai.common.domain.model.ChatItem
import dev.partemy.zmeuai.common.domain.model.ChatItemType
import dev.partemy.zmeuai.common.resources.ZmeuaiResources
import org.jetbrains.compose.resources.painterResource
import zmeuai.common.resources.generated.resources.Res
import zmeuai.common.resources.generated.resources.cloud_download
import zmeuai.common.resources.generated.resources.copy
import zmeuai.common.resources.generated.resources.edit
import zmeuai.common.resources.generated.resources.eye
import zmeuai.common.resources.generated.resources.reload
import zmeuai.common.resources.generated.resources.send


@Composable
fun ZmeuaiChatItem(
    modifier: Modifier = Modifier,
    chatItem: ChatItem,
    onActionClick: (ChatItemAction) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth().padding(SectionPadding)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ) {
            Image(
                painterResource(Res.drawable.eye),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = chatItem.name,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Spacer(modifier = Modifier.height(SectionPadding))
        Text(
            text = chatItem.text,
            color = MaterialTheme.chatColorOf(chatItem.type),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(SectionPadding))
        Row(modifier = Modifier.fillMaxWidth()) {
            ChatActionButtons(
                modifier = Modifier,
                type = chatItem.type,
                onActionClick = onActionClick
            )
        }
    }
}


@Composable
private fun ChatActionButtons(
    modifier: Modifier = Modifier,
    type: ChatItemType,
    onActionClick: (ChatItemAction) -> Unit
) {
    when (type) {
        ChatItemType.IMAGE -> {
            ChatButton(
                icon = Res.drawable.cloud_download,
                text = ZmeuaiResources.strings.download,
                onClick = { onActionClick(ChatItemAction.Download) }
            )
            Spacer(modifier = Modifier.width(16.dp))
            ChatButton(
                icon = Res.drawable.send,
                text = ZmeuaiResources.strings.share,
                onClick = { onActionClick(ChatItemAction.Share) }
            )
            Spacer(modifier = Modifier.width(16.dp))
            ChatButton(
                icon = Res.drawable.reload,
                text = ZmeuaiResources.strings.regenerate,
                onClick = { onActionClick(ChatItemAction.Regenerate) }
            )
        }

        ChatItemType.TEXT -> {
            ChatButton(
                icon = Res.drawable.copy,
                text = ZmeuaiResources.strings.copy,
                onClick = { onActionClick(ChatItemAction.Copy) }
            )
            Spacer(modifier = Modifier.width(16.dp))
            ChatButton(
                icon = Res.drawable.send,
                text = ZmeuaiResources.strings.share,
                onClick = { onActionClick(ChatItemAction.Share) }
            )
            Spacer(modifier = Modifier.width(16.dp))
            ChatButton(
                icon = Res.drawable.reload,
                text = ZmeuaiResources.strings.regenerate,
                onClick = { onActionClick(ChatItemAction.Regenerate) }
            )
        }

        ChatItemType.USER -> {
            ChatButton(
                icon = Res.drawable.edit,
                text = ZmeuaiResources.strings.edit,
                onClick = { onActionClick(ChatItemAction.Edit) }
            )
            Spacer(modifier = Modifier.width(16.dp))
            ChatButton(
                icon = Res.drawable.copy,
                text = ZmeuaiResources.strings.copy,
                onClick = { onActionClick(ChatItemAction.Copy) }
            )
        }
    }
}

//TODO move
@Immutable
sealed class ChatItemAction {
    data object Edit : ChatItemAction()
    data object Copy : ChatItemAction()
    data object Share : ChatItemAction()
    data object Regenerate : ChatItemAction()
    data object Download : ChatItemAction()
}
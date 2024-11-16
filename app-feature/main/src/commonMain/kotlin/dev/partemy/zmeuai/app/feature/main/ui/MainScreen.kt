package dev.partemy.zmeuai.app.feature.main.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.partemy.zmeuai.app.ui.components.ChatCard
import dev.partemy.zmeuai.app.ui.components.ZmeuaiButton
import dev.partemy.zmeuai.app.ui.components.ZmeuaiTextField
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiTheme
import dev.partemy.zmeuai.app.ui.values.MediumPadding
import dev.partemy.zmeuai.app.ui.values.SectionPadding
import dev.partemy.zmeuai.app.ui.values.SmallPadding
import dev.partemy.zmeuai.common.domain.model.Chat
import dev.partemy.zmeuai.common.domain.model.ChatItem
import dev.partemy.zmeuai.common.resources.ZmeuaiResources
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import zmeuai.common.resources.generated.resources.Res
import zmeuai.common.resources.generated.resources.chat
import zmeuai.common.resources.generated.resources.image
import zmeuai.common.resources.generated.resources.inbox
import zmeuai.common.resources.generated.resources.logo
import zmeuai.common.resources.generated.resources.search

val chats = listOf(
    Chat(
        chatID = 1,
        title = "Android Development",
        text = "Discuss the latest Android features and development practices.",
        creationTime = 1
    ),
    Chat(
        chatID = 2,
        title = "Jetpack Compose",
        text = "Share your experiences and tips on using Jetpack Compose.",
        creationTime = 1
    ),
    Chat(
        chatID = 3,
        title = "Kotlin Coroutines",
        text = "Learn about and discuss Kotlin coroutines for asynchronous programming.",
        creationTime = 1
    )
)

@Composable
fun MainScreen() {
    ZmeuaiTheme {
        Content(
            modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars),
            chats = chats,
            onNewChatClick = { },
            onSortTextFieldValueChange = { },
            onSortButtonClick = {},
            onChatClick = {}
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Content(
    modifier: Modifier = Modifier,
    chats: List<Chat>,
    onNewChatClick: () -> Unit,
    onSortTextFieldValueChange: (String) -> Unit,
    onSortButtonClick: (Int) -> Unit,
    onChatClick: (Long) -> Unit,
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            Title(
                onNewChatClick = onNewChatClick,
            )
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(SectionPadding),
            modifier = Modifier.padding(innerPadding)
        ) {
            HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
            SortTextField(onTextFieldValueChange = onSortTextFieldValueChange)
            SortButtons(onSortButtonClick = onSortButtonClick)
            FlowRow(
                maxItemsInEachRow = 2,
                horizontalArrangement = Arrangement.spacedBy(SmallPadding),
                verticalArrangement = Arrangement.spacedBy(SmallPadding),
                modifier = Modifier.padding(horizontal = SectionPadding)
            ) {
                chats.forEach { chat ->
                    ChatCard(
                        modifier = Modifier.weight(1f),
                        title = chat.title,
                        text = chat.text,
                        time = chat.creationTime.toString(),
                        onClick = { onChatClick(chat.chatID) }
                    )
                }
            }
        }
    }

}


@Composable
private fun SortTextField(
    modifier: Modifier = Modifier,
    onTextFieldValueChange: (String) -> Unit
) {
    val textFieldValue = rememberSaveable { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(horizontal = SectionPadding)
    ) {
        Text(
            text = ZmeuaiResources.strings.history,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.width(MediumPadding))
        ZmeuaiTextField(
            modifier = Modifier.weight(1f),
            value = textFieldValue.value,
            onValueChange = { textFieldValue.value = it; onTextFieldValueChange(it) },
            placeholder = {
                Text(
                    text = ZmeuaiResources.strings.search,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.surfaceVariant,
                )
            },
            trailingIcon = {
                Icon(
                    vectorResource(Res.drawable.search),
                    contentDescription = ZmeuaiResources.strings.search,
                    modifier = Modifier.size(16.dp)
                )
            }
        )
    }
}

@Composable
private fun SortButtons(modifier: Modifier = Modifier, onSortButtonClick: (Int) -> Unit) {
    val activeButtonIndex = rememberSaveable { mutableStateOf(0) }
    val scrollState = rememberScrollState()
    Row(
        modifier = modifier
            .horizontalScroll(scrollState)
            .padding(horizontal = SectionPadding),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        ZmeuaiButton(
            onClick = { activeButtonIndex.value = 0; onSortButtonClick(activeButtonIndex.value) },
            text = ZmeuaiResources.strings.chats,
            icon = Res.drawable.chat,
            isActive = activeButtonIndex.value == 0,
        )
        ZmeuaiButton(
            onClick = { activeButtonIndex.value = 1; onSortButtonClick(activeButtonIndex.value) },
            text = ZmeuaiResources.strings.archived,
            icon = Res.drawable.inbox,
            isActive = activeButtonIndex.value == 1,
        )
        ZmeuaiButton(
            onClick = { activeButtonIndex.value = 2; onSortButtonClick(activeButtonIndex.value) },
            text = ZmeuaiResources.strings.images,
            icon = Res.drawable.image,
            isActive = activeButtonIndex.value == 2,
        )
    }
}

@Composable
private fun Title(
    modifier: Modifier = Modifier,
    onNewChatClick: () -> Unit
) {
    Column(
        modifier = modifier.padding(SectionPadding),
        verticalArrangement = Arrangement.spacedBy(SmallPadding)
    ) {
        TitleText(ZmeuaiResources.strings.startANewChat)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TitleText(ZmeuaiResources.strings.with)
            Spacer(modifier = Modifier.width(SmallPadding))
            Image(
                painter = painterResource(Res.drawable.logo),
                contentDescription = ZmeuaiResources.strings.zmeuai,
                modifier = Modifier.size(28.dp)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            TitleText(ZmeuaiResources.strings.zmeu_AI)
            Spacer(modifier = Modifier.width(32.dp))
            Button(onClick = onNewChatClick) {
                Text(text = ZmeuaiResources.strings.newTopic)
            }
        }
    }

}

@Composable
private fun TitleText(
    text: String,
    color: Color = MaterialTheme.colorScheme.onBackground,
) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.headlineLarge,
    )
}
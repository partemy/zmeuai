package dev.partemy.zmeuai.app.feature.chat.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import dev.partemy.zmeuai.app.ui.components.ChatItemAction
import dev.partemy.zmeuai.app.ui.components.ZmeuaiChatItem
import dev.partemy.zmeuai.app.ui.components.ZmeuaiTextField
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiTheme
import dev.partemy.zmeuai.common.domain.model.ChatItem
import dev.partemy.zmeuai.common.resources.ProvideZmeuaiStrings
import dev.partemy.zmeuai.common.resources.ZmeuaiResources
import org.jetbrains.compose.resources.vectorResource
import org.koin.compose.koinInject
import zmeuai.common.resources.generated.resources.Res
import zmeuai.common.resources.generated.resources.send


@Composable
fun ChatScreen(modifier: Modifier = Modifier, viewModel: ChatViewModel = koinInject()) {
    val uiState = viewModel.uiState.collectAsState()
    ProvideZmeuaiStrings {
        ZmeuaiTheme {
            Scaffold(
                topBar = {
                    Box(
                        modifier = Modifier.height(100.dp).fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primary)
                    )
                }
            ) { innerPadding ->
                Content(
                    modifier = Modifier.padding(innerPadding),
                    chatItems = uiState.value.chat,
                    onActionClick = { },
                    onSendClick = { viewModel.onTriggerEvent(ChatViewEvent.OnSendClick(it)) }
                )
            }
        }
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    chatItems: List<ChatItem>,
    onActionClick: (ChatItemAction) -> Unit,
    onSendClick: (String) -> Unit,
) {
    val lazyColumnState = rememberLazyListState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val textFieldValue = rememberSaveable { mutableStateOf("") }
    val imePadding = with(LocalDensity.current) {
        WindowInsets.ime.getBottom(this).toDp() - WindowInsets.navigationBars.getBottom(this)
            .toDp()
    }
    val imeHeight = if (imePadding > 0.dp) imePadding else 0.dp

    LaunchedEffect(key1 = chatItems) {
        if (chatItems.isNotEmpty())
            lazyColumnState.animateScrollToItem(chatItems.lastIndex, scrollOffset = 20000)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .offset(y = -imeHeight)
            .pointerInput(Unit) { detectTapGestures { keyboardController?.hide() } }
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            state = lazyColumnState,
        ) {
            item { Spacer(modifier = Modifier.height(imeHeight)) }
            itemsIndexed(chatItems) { index, item ->
                if (index != 0) HorizontalDivider(
                    thickness = 0.5.dp,
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                )
                ZmeuaiChatItem(
                    chatItem = item,
                    onActionClick = onActionClick,
                )
            }
        }
        ChatTextField(
            modifier = Modifier,
            value = textFieldValue.value,
            onValueChange = { textFieldValue.value = it },
            onSendClick = { onSendClick.invoke(textFieldValue.value); textFieldValue.value = "" },
        )
    }
}

@Composable
private fun ChatTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onSendClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 12.dp)

    ) {
        ZmeuaiTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.weight(1f).height(64.dp),
            placeholder = {
                Text(
                    text = ZmeuaiResources.strings.askMeAnything,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.surfaceVariant,
                )
            },
            singleLine = true
        )
        Spacer(Modifier.width(12.dp))
        IconButton(
            modifier = Modifier.size(64.dp),
            onClick = onSendClick,
            colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Icon(
                vectorResource(Res.drawable.send),
                contentDescription = ZmeuaiResources.strings.send,
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}
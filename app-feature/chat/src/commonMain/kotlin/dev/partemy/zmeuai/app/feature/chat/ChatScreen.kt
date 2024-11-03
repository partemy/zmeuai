package dev.partemy.zmeuai.app.feature.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.captionBar
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.waterfall
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.ImeOptions
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import dev.partemy.zmeuai.app.ui.components.ChatItemAction
import dev.partemy.zmeuai.app.ui.components.ZmeuaiChatItem
import dev.partemy.zmeuai.app.ui.components.ZmeuaiTextField
import dev.partemy.zmeuai.app.ui.theme.ZmeuaiTheme
import dev.partemy.zmeuai.common.domain.model.ChatItem
import dev.partemy.zmeuai.common.domain.model.ChatItemType
import dev.partemy.zmeuai.common.resources.ProvideZmeuaiStrings
import dev.partemy.zmeuai.common.resources.ZmeuaiResources
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.vectorResource
import zmeuai.common.resources.generated.resources.Res
import zmeuai.common.resources.generated.resources.send

@Composable
fun ChatScreen(modifier: Modifier = Modifier) {
    ProvideZmeuaiStrings {
        ZmeuaiTheme {
            val value = remember { mutableStateOf("") }
            Content(
                list = listOf(
                    ChatItem(
                        id = "",
                        name = "You",
                        text = "hellow how are you",
                        type = ChatItemType.USER,
                    ),
                    ChatItem(
                        id = "",
                        name = "bob",
                        text = "propriae rhoncus morbi venenatis turpis odio eum discere tacimates aperiri menandri dapibus ac interdum tractatos posidonium dicit deterruisset consetetur comprehensam fabulas nostra aptent idque perpetua mnesarchum tamquam montes mediocrem per expetendis instructior inani habemus quaeque an doctus ius postea deserunt et utroque affert recteque quod doctus per iusto ancillae intellegebat",
                        type = ChatItemType.TEXT,
                    ),
                    ChatItem(
                        id = "",
                        name = "bob",
                        text = "propriae rhoncus morbi venenatis turpis odio eum discere tacimates aperiri menandri dapibus ac interdum tractatos posidonium dicit deterruisset consetetur comprehensam fabulas nostra aptent idque perpetua mnesarchum tamquam montes mediocrem per expetendis instructior inani habemus quaeque an doctus ius postea deserunt et utroque affert recteque quod doctus per iusto ancillae intellegebat",
                        type = ChatItemType.TEXT,
                    ),
                    ChatItem(
                        id = "",
                        name = "bob",
                        text = "propriae rhoncus morbi venenatis turpis odio eum discere tacimates aperiri menandri dapibus ac interdum tractatos posidonium dicit deterruisset consetetur comprehensam fabulas nostra aptent idque perpetua mnesarchum tamquam montes mediocrem per expetendis instructior inani habemus quaeque an doctus ius postea deserunt et utroque affert recteque quod doctus per iusto ancillae intellegebat",
                        type = ChatItemType.TEXT,
                    ),
                    ChatItem(
                        id = "",
                        name = "You",
                        text = "nice",
                        type = ChatItemType.USER,
                    ),
                    ChatItem(
                        id = "",
                        name = "zmeuai",
                        text = "dolores definiebas error wisi petentium himenaeos tristique sollicitudin fuisset faucibus eleifend sollicitudin adversarium sit ridens",
                        type = ChatItemType.TEXT,
                    ),
                    ChatItem(
                        id = "",
                        name = "You",
                        text = "nice",
                        type = ChatItemType.USER,
                    ),
                    ChatItem(
                        id = "",
                        name = "zmeuai",
                        text = "dolores definiebas error wisi petentium himenaeos tristique sollicitudin fuisset faucibus eleifend sollicitudin adversarium sit ridens",
                        type = ChatItemType.TEXT,
                    )
                ),

                onActionClick = { },
                textFieldValue = value.value,
                onTextFieldValueChange = { value.value = it },
                onSendClick = {}
            )
        }
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    list: List<ChatItem>,
    onActionClick: (ChatItemAction) -> Unit,
    textFieldValue: String,
    onTextFieldValueChange: (String) -> Unit,
    onSendClick: () -> Unit,
) {
    val lazyColumnState = rememberLazyListState()
    val keyboardController = LocalSoftwareKeyboardController.current

    val lazyColumnModifier: Modifier = Modifier
        .pointerInput(Unit) { detectTapGestures { keyboardController?.hide() } }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        LazyColumn(
            modifier = lazyColumnModifier.weight(1f),
            state = lazyColumnState,
        ) {
            itemsIndexed(list) { index, item ->
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
            value = textFieldValue,
            onValueChange = onTextFieldValueChange,
            onSendClick = onSendClick,
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
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .windowInsetsPadding(WindowInsets.navigationBars)
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
        Spacer(modifier.width(12.dp))
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
package dev.partemy.zmeuai.app.feature.chat.ui

import androidx.lifecycle.viewModelScope
import dev.partemy.zmeuai.app.ui.base.BaseViewModel
import dev.partemy.zmeuai.app.ui.base.IViewEvent
import dev.partemy.zmeuai.common.domain.ResultState
import dev.partemy.zmeuai.common.domain.model.ChatItem
import dev.partemy.zmeuai.common.domain.model.ChatItemType
import dev.partemy.zmeuai.common.domain.usecase.GetMessageUseCase
import kotlinx.coroutines.launch

class ChatViewModel(
    private val getMessageUseCase: GetMessageUseCase,
) : BaseViewModel<ChatViewState, ChatViewEvent>() {
    override fun createInitialState(): ChatViewState = ChatViewState()
    override fun onTriggerEvent(event: ChatViewEvent) {
        viewModelScope.launch {
            when (event) {
                is ChatViewEvent.OnSendClick -> {
                    getMessage(event.message)
                }
            }
        }
    }

    private suspend fun getMessage(message: String) {
        if (message.isNotBlank()) {
            addChatItem(text = message, type = ChatItemType.USER)
            getMessageUseCase.invoke(
                chat = uiState.value.chat,
                message = message
            ).collect {
                when (it) {
                    is ResultState.Failure -> {
                        setState {
                            currentState.copy(
                                chat = listOf(
                                    ChatItem(
                                        text = it.exception.message ?: "no exc",
                                        type = ChatItemType.TEXT
                                    )
                                )
                            )
                        }

                    }

                    is ResultState.Loading -> {
                        setState {
                            currentState.copy(
                                chat = listOf(
                                    ChatItem(
                                        text = "loading",
                                        type = ChatItemType.TEXT
                                    )
                                )
                            )
                        }
                    }

                    is ResultState.Success -> {
                        addChatItem(it.data, ChatItemType.TEXT)
                    }
                }
            }
        }
    }

    private fun addChatItem(
        text: String,
        type: ChatItemType
    ) {
        setState {
            currentState.copy(
                chat = currentState.chat.plus(
                    ChatItem(
                        text = text,
                        type = type
                    )
                )
            )
        }
    }
}


sealed class ChatViewEvent : IViewEvent {
    class OnSendClick(val message: String) : ChatViewEvent()
}
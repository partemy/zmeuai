package dev.partemy.zmeuai.app.feature.chat.ui

import androidx.lifecycle.viewModelScope
import dev.partemy.zmeuai.app.ui.base.BaseViewModel
import dev.partemy.zmeuai.app.ui.base.IViewEvent
import dev.partemy.zmeuai.common.domain.usecase.GenerateMessageUseCase
import dev.partemy.zmeuai.common.domain.usecase.GetMessageUseCase
import kotlinx.coroutines.launch

class ChatViewModel(
    private val chatID: Long,
    private val getMessageUseCase: GetMessageUseCase,
    private val generateMessageUseCase: GenerateMessageUseCase,
) : BaseViewModel<ChatViewState, ChatViewEvent>() {
    override fun createInitialState(): ChatViewState = ChatViewState()
    override fun onTriggerEvent(event: ChatViewEvent) {
        viewModelScope.launch {
            when (event) {
                is ChatViewEvent.OnSendClick -> {
                    generateMessage(event.message)
                }
            }
        }
    }

    val messages = getMessageUseCase.invoke(chatID)

    private fun generateMessage(message: String) {
        viewModelScope.launch {
            generateMessageUseCase.invoke(message, chatID)
        }
    }
}


sealed class ChatViewEvent : IViewEvent {
    class OnSendClick(val message: String) : ChatViewEvent()
}
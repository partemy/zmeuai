package dev.partemy.zmeuai.app.feature.chat.ui

import dev.partemy.zmeuai.app.ui.base.BaseViewModel
import dev.partemy.zmeuai.app.ui.base.IViewEvent

class ChatViewModel : BaseViewModel<ChatViewState, ChatViewEvent>() {
    override fun createInitialState(): ChatViewState = ChatViewState()
    override fun onTriggerEvent(event: ChatViewEvent) {
        when (event) {
            is ChatViewEvent.UpdateText -> {
                setState { currentState.copy(text = event.text) }
            }
        }
    }

}

sealed class ChatViewEvent : IViewEvent {
    class UpdateText(val text: String) : ChatViewEvent()
}
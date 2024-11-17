package dev.partemy.zmeuai.app.feature.main.ui

import androidx.lifecycle.viewModelScope
import dev.partemy.zmeuai.app.ui.base.BaseViewModel
import dev.partemy.zmeuai.app.ui.base.IViewEvent
import dev.partemy.zmeuai.common.domain.usecase.AddChatUseCase
import dev.partemy.zmeuai.common.domain.usecase.GetChatsUseCase
import dev.partemy.zmeuai.common.domain.usecase.GetLastChatUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getChatsUseCase: GetChatsUseCase,
    private val addChatUseCase: AddChatUseCase,
    private val getLastChatUseCase: GetLastChatUseCase,
) : BaseViewModel<MainViewState, MainViewEvent>() {
    override fun createInitialState(): MainViewState = MainViewState()

    override fun onTriggerEvent(event: MainViewEvent) {
        viewModelScope.launch {
            when (event) {
                is MainViewEvent.OnAddNewChatClick -> {
                    addNewChat(event.nav)
                }
            }
        }
    }

    val chats = getChatsUseCase.invoke()

    private suspend fun addNewChat(nav: (Long) -> Unit) {
        addChatUseCase.invoke()
        val id = getLastChatUseCase.invoke()
        if (id != null) nav.invoke(id)

    }

}

sealed class MainViewEvent : IViewEvent {
    class OnAddNewChatClick(val nav: (Long) -> Unit) : MainViewEvent()
}
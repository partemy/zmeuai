package dev.partemy.zmeuai.app.feature.main.ui

import dev.partemy.zmeuai.app.ui.base.BaseViewModel
import dev.partemy.zmeuai.app.ui.base.IViewEvent

class MainViewModel : BaseViewModel<MainViewState, MainViewEvent>() {
    override fun createInitialState(): MainViewState = MainViewState()

    override fun onTriggerEvent(event: MainViewEvent) {

    }

}

sealed class MainViewEvent : IViewEvent
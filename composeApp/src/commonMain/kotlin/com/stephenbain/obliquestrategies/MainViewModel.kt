package com.stephenbain.obliquestrategies

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    
    private val _state = MutableStateFlow(MainState(text = "strategy"))
    
    val state: StateFlow<MainState>
        get() = _state.asStateFlow()
}

data class MainState(val text: String)
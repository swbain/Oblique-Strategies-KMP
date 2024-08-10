package com.stephenbain.obliquestrategies

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel { MainViewModel() }) {
    val state by viewModel.state.collectAsState()
    MainLayout(state)
}

@Composable
fun MainLayout(state: MainState) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = state.text, modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
@Preview
fun MainPreview() {
    MaterialTheme {
        MainLayout(MainState(text = "text"))
    }
}
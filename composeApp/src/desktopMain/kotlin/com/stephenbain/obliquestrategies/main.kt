package com.stephenbain.obliquestrategies

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "oblique-strategies-kmp",
    ) {
        App()
    }
}
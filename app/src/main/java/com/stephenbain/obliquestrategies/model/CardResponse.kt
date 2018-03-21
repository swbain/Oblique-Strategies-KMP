package com.stephenbain.obliquestrategies.model

data class CardResponse(
        val id: String,
        val edition: String,
        val cardNumber: Int,
        val strategy: String
)
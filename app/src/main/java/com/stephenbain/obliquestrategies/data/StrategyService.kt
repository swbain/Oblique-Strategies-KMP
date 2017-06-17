package com.stephenbain.obliquestrategies.data

import com.stephenbain.obliquestrategies.model.CardResponse
import retrofit2.Call
import retrofit2.http.GET

interface StrategyService {

    @GET("draw")
    fun requestStrategy() : Call<CardResponse>

}
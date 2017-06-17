package com.stephenbain.obliquestrategies.data

import com.stephenbain.obliquestrategies.model.CardResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface StrategyService {

    @GET("draw")
    fun requestStrategy() : Observable<CardResponse>

}
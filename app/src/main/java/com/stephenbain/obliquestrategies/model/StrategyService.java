package com.stephenbain.obliquestrategies.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StrategyService {

    @GET("draw")
    Call<Strategy> getNewStrategy();
}

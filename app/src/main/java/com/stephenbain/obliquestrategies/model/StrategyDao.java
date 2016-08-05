package com.stephenbain.obliquestrategies.model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Inject;

public class StrategyDao {

    private final StrategyService strategyService;

    @Inject
    public StrategyDao(StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    public void requestStrategy(final Callback callback) {
        strategyService.getNewStrategy().enqueue(new retrofit2.Callback<Strategy>() {
            @Override
            public void onResponse(Call<Strategy> call, Response<Strategy> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Strategy> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public interface Callback {
        void onSuccess(Strategy strategy);
        void onError();
    }
}

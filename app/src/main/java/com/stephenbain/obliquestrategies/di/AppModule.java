package com.stephenbain.obliquestrategies.di;

import android.app.Application;
import android.content.Context;
import com.stephenbain.obliquestrategies.model.StrategyService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

@Module
public class AppModule {

    Context context;

    public AppModule() {
    }

    public void setApplication(Application application) {
        context = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    StrategyService providesStrategyService() {
        return new Retrofit.Builder()
                .baseUrl("http://brianeno.needsyourhelp.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(StrategyService.class);
    }
}

package com.stephenbain.obliquestrategies.di

import android.app.Application
import android.content.Context
import com.stephenbain.obliquestrategies.data.StrategyService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module class AppModule(val application: Application) {

    @Provides @Singleton fun provideContext() : Context = application

    @Provides @Singleton fun provideStrategyService() : StrategyService {
        val retrofit = Retrofit.Builder().baseUrl("http://brianeno.needsyourhelp.org/").build()

        return retrofit.create(StrategyService::class.java)
    }

}
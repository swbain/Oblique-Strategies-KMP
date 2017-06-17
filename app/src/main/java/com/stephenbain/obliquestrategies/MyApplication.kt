package com.stephenbain.obliquestrategies

import android.app.Application
import com.stephenbain.obliquestrategies.di.AppComponent
import com.stephenbain.obliquestrategies.di.AppModule
import com.stephenbain.obliquestrategies.di.DaggerAppComponent

class MyApplication : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

}

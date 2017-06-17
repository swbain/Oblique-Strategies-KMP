package com.stephenbain.obliquestrategies.di

import com.stephenbain.obliquestrategies.MyApplication
import com.stephenbain.obliquestrategies.view.HomeActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(application: MyApplication)
    fun inject(activity: HomeActivity)
}
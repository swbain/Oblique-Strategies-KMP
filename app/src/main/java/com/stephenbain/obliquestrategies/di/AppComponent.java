package com.stephenbain.obliquestrategies.di;

import com.stephenbain.obliquestrategies.view.HomeActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(HomeActivity activity);
}

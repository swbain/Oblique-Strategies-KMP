package com.stephenbain.obliquestrategies;

import android.app.Application;
import com.stephenbain.obliquestrategies.di.AppComponent;
import com.stephenbain.obliquestrategies.di.AppModule;
import com.stephenbain.obliquestrategies.di.DaggerAppComponent;

public class MyApplication extends Application {

    private static final AppComponent COMPONENT;
    private static final AppModule MODULE;

    static {
        COMPONENT = DaggerAppComponent.builder().appModule(MODULE = new AppModule()).build();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        MODULE.setApplication(this);
    }

    public static AppComponent getComponent() {
        return COMPONENT;
    }
}

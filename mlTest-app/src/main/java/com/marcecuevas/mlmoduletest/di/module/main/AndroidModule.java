package com.marcecuevas.mlmoduletest.di.module.main;

import android.content.Context;
import android.content.res.Resources;
import com.marcecuevas.mlmoduletest.main.MLApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {
    private MLApplication application;

    public AndroidModule(MLApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return application.getResources();
    }

}
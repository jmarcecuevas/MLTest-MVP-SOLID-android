package com.marcecuevas.mlmoduletest.main;

import android.app.Application;
import android.content.Context;

import com.marcecuevas.mlmoduletest.di.component.main.ApplicationComponent;
import com.marcecuevas.mlmoduletest.di.component.main.DaggerApplicationComponent;
import com.marcecuevas.mlmoduletest.di.module.main.AndroidModule;
import com.marcecuevas.mlmoduletest.di.module.main.ApplicationModule;

public class MLApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = createComponent();
    }

    public static MLApplication get(Context context) {
        return (MLApplication) context.getApplicationContext();
    }

    public ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder()
                .androidModule(new AndroidModule(this))
                .applicationModule(new ApplicationModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
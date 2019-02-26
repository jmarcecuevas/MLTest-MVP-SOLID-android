package com.marcecuevas.mlmoduletest.main;

import android.app.Application;
import android.content.Context;

import com.marcecuevas.mlmoduletest.R;
import com.marcecuevas.mlmoduletest.di.componente.ApplicationComponent;
import com.marcecuevas.mlmoduletest.di.componente.DaggerApplicationComponent;
import com.marcecuevas.mlmoduletest.di.modulee.AndroidModule;
import com.marcecuevas.mlmoduletest.di.modulee.ApplicationModule;
import com.marcecuevas.mlmoduletest.utils.MLFont;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MLApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        MLFont.getInstance().setFamilyName("Montserrat",this);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(MLFont.getInstance().defaultPath())
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

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
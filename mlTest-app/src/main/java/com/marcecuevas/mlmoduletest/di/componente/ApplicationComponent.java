package com.marcecuevas.mlmoduletest.di.componente;

import com.marcecuevas.mlmoduletest.di.modulee.AndroidModule;
import com.marcecuevas.mlmoduletest.di.modulee.ApplicationModule;
import com.marcecuevas.mlmoduletest.di.subcomponent.HomeSubcomponent;
import com.marcecuevas.mlmoduletest.di.subcomponent.PaymentSubcomponent;
import com.marcecuevas.mlmoduletest.ui.activity.SplashActivity;
import com.marcecuevas.mlmoduletest.ui.activity.common.BaseActivity;
import com.marcecuevas.mltest_core.di.module.HomeModule;
import com.marcecuevas.mltest_core.di.module.PaymentModule;
import com.marcecuevas.mltest_core.di.module.rest.ApiModule;
import com.marcecuevas.mltest_core.di.module.rest.ClientModule;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {
        AndroidModule.class,
        ApplicationModule.class,
        ApiModule.class,
        ClientModule.class
})

public interface ApplicationComponent {

    void inject(SplashActivity activity);
    void inject(BaseActivity activity);

    HomeSubcomponent plus(HomeModule module);
    PaymentSubcomponent plus (PaymentModule module);
}


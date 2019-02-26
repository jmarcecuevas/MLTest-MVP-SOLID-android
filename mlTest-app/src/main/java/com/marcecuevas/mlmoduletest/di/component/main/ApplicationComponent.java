package com.marcecuevas.mlmoduletest.di.component.main;

import com.marcecuevas.mlmoduletest.di.module.main.AndroidModule;
import com.marcecuevas.mlmoduletest.di.module.main.ApplicationModule;
import com.marcecuevas.mlmoduletest.di.subcomponent.login.LoginSubcomponent;
import com.marcecuevas.mlmoduletest.ui.activity.MainActivity;
import com.marcecuevas.mlmoduletest.ui.activity.SplashActivity;
import com.marcecuevas.mltest_core.di.module.login.LoginModule;
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
    void inject(MainActivity activity);

    LoginSubcomponent plus(LoginModule module);

//    void inject(CharacterActivity characterActivity);
//
//    SearchSubComponent plus(SearchModule module);
//
//    CacheSubComponent plus(CacheModule module);

}


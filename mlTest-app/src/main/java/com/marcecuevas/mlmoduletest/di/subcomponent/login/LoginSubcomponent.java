package com.marcecuevas.mlmoduletest.di.subcomponent.login;

import com.marcecuevas.mlmoduletest.ui.fragment.MainFragment;
import com.marcecuevas.mltest_core.di.module.login.LoginModule;
import com.marcecuevas.mltest_core.di.scope.LoginScope;

import dagger.Subcomponent;

@LoginScope
@Subcomponent(modules = {
        LoginModule.class
})
public interface LoginSubcomponent {
    void inject(MainFragment fragment);
}

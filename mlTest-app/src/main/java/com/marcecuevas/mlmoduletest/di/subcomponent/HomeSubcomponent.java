package com.marcecuevas.mlmoduletest.di.subcomponent;

import com.marcecuevas.mlmoduletest.ui.fragment.HomeFragment;
import com.marcecuevas.mltest_core.di.module.HomeModule;
import com.marcecuevas.mltest_core.di.scope.HomeScope;
import dagger.Subcomponent;

@HomeScope
@Subcomponent(modules = {
        HomeModule.class
})
public interface HomeSubcomponent {
    void inject(HomeFragment fragment);
}


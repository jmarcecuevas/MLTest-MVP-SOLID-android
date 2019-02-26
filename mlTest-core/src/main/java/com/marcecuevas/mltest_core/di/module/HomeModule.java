package com.marcecuevas.mltest_core.di.module;

import com.marcecuevas.mltest_core.di.scope.HomeScope;
import com.marcecuevas.mltest_core.presenter.HomePresenter;
import com.marcecuevas.mltest_core.presenter.HomePresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    @Provides
    @HomeScope
    public HomePresenter providePresenter(HomePresenterImpl presenter){
        return presenter;
    }
}

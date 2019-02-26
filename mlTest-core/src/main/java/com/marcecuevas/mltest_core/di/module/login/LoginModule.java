package com.marcecuevas.mltest_core.di.module.login;

import com.marcecuevas.mltest_core.dao.login.LoginDAO;
import com.marcecuevas.mltest_core.dao.login.LoginDAOImp;
import com.marcecuevas.mltest_core.di.scope.LoginScope;
import com.marcecuevas.mltest_core.presenter.login.LoginPresenter;
import com.marcecuevas.mltest_core.presenter.login.LoginPresenterImp;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

//    private LoginView loginView;
//
//    public LoginModule(LoginView loginView){
//        this.loginView = loginView;
//    }
//
//    @Provides
//    @LoginScope
//    public LoginView provideLoginView(){
//        return loginView;
//    }

    @Provides
    @LoginScope
    public LoginPresenter providePresenter(LoginPresenterImp presenter){
        return presenter;
    }

    @Provides
    @LoginScope
    public LoginDAO provideLoginDAO(LoginDAOImp dao){
        return dao;
    }

//    @Provides
//    @LoginScope
//    public RetrofitDAO provideDAO(LoginDAOImp dao){
//        return dao;
//    }
}

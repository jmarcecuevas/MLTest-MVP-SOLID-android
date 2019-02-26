package com.marcecuevas.mltest_core.di.module;

import com.marcecuevas.mltest_core.dao.PaymentDAO;
import com.marcecuevas.mltest_core.dao.PaymentDAOImpl;
import com.marcecuevas.mltest_core.di.scope.PaymentScope;
import com.marcecuevas.mltest_core.presenter.PaymentPresenter;
import com.marcecuevas.mltest_core.presenter.PaymentPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class PaymentModule {

    @Provides
    @PaymentScope
    public PaymentPresenter providePresenter(PaymentPresenterImpl presenter){
        return presenter;
    }

    @Provides
    @PaymentScope
    public PaymentDAO provideContactoDAO(PaymentDAOImpl dao){
        return dao;
    }
}
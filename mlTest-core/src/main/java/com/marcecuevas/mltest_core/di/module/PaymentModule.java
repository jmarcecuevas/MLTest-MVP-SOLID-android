package com.marcecuevas.mltest_core.di.module;

import com.marcecuevas.mltest_core.dao.PaymentDAO;
import com.marcecuevas.mltest_core.dao.PaymentDAOImpl;
import com.marcecuevas.mltest_core.di.scope.PaymentScope;
import com.marcecuevas.mltest_core.presenter.BankPresenter;
import com.marcecuevas.mltest_core.presenter.BankPresenterImpl;
import com.marcecuevas.mltest_core.presenter.DuesSelectorPresenter;
import com.marcecuevas.mltest_core.presenter.DuesSelectorPresenterImpl;
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
    public PaymentDAO providePaymentDAO(PaymentDAOImpl dao){
        return dao;
    }

    @Provides
    @PaymentScope
    public BankPresenter provideBankPresenter(BankPresenterImpl presenter){
        return presenter;
    }

    @Provides
    @PaymentScope
    public DuesSelectorPresenter provideDuesPresenter(DuesSelectorPresenterImpl presenter){
        return presenter;
    }
}
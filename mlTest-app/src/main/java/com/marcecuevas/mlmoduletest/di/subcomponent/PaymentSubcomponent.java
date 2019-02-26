package com.marcecuevas.mlmoduletest.di.subcomponent;

import com.marcecuevas.mlmoduletest.ui.fragment.BankFragment;
import com.marcecuevas.mlmoduletest.ui.fragment.DuesSelectorFragment;
import com.marcecuevas.mlmoduletest.ui.fragment.HomeFragment;
import com.marcecuevas.mlmoduletest.ui.fragment.PaymentMethodFragment;
import com.marcecuevas.mltest_core.di.module.HomeModule;
import com.marcecuevas.mltest_core.di.module.PaymentModule;
import com.marcecuevas.mltest_core.di.scope.HomeScope;
import com.marcecuevas.mltest_core.di.scope.PaymentScope;

import dagger.Subcomponent;

@PaymentScope
@Subcomponent(modules = {
        PaymentModule.class
})
public interface PaymentSubcomponent {
    void inject(PaymentMethodFragment fragment);
    void inject(BankFragment fragment);
    void inject(DuesSelectorFragment fragment);
}

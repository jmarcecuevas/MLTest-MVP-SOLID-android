package com.marcecuevas.mltest_core.presenter;

import com.marcecuevas.mltest_core.presenter.common.BasePresenter;
import com.marcecuevas.mltest_core.viewModel.PaymentView;

public interface PaymentPresenter extends BasePresenter<PaymentView> {

    void paymentMethods();
}

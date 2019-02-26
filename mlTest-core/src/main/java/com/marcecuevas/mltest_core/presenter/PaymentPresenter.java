package com.marcecuevas.mltest_core.presenter;

import com.marcecuevas.mltest_core.model.dto.PaymentMethodDTO;
import com.marcecuevas.mltest_core.presenter.common.BasePresenter;
import com.marcecuevas.mltest_core.viewModel.PaymentView;

import java.util.ArrayList;
import java.util.List;

public interface PaymentPresenter extends BasePresenter<PaymentView> {

    void paymentMethods();
    List<PaymentMethodDTO> filterCreditCards(List<PaymentMethodDTO> paymentMethods);
}

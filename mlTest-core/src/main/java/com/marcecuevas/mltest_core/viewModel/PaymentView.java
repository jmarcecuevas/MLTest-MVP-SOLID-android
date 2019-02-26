package com.marcecuevas.mltest_core.viewModel;

import com.marcecuevas.mltest_core.model.dto.PaymentMethodDTO;
import com.marcecuevas.mltest_core.viewModel.common.BaseView;

import java.util.List;

public interface PaymentView extends BaseView {

    void onPaymentMethodSelected(PaymentMethodDTO payment);
    void showPaymentMethods(List<PaymentMethodDTO> items);
    void showEmptyState();
}

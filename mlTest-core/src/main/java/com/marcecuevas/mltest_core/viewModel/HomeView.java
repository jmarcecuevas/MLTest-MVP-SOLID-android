package com.marcecuevas.mltest_core.viewModel;

import com.marcecuevas.mltest_core.model.SelectionModel;
import com.marcecuevas.mltest_core.viewModel.common.BaseView;

public interface HomeView extends BaseView {

    void goToPaymentMethodSelector(SelectionModel item);
}

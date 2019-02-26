package com.marcecuevas.mltest_core.presenter;

import com.marcecuevas.mltest_core.model.SelectionModel;
import com.marcecuevas.mltest_core.presenter.common.BasePresenter;
import com.marcecuevas.mltest_core.viewModel.DuesView;


public interface DuesSelectorPresenter extends BasePresenter<DuesView> {

    void installmentOptions(SelectionModel selection, String installments);
}

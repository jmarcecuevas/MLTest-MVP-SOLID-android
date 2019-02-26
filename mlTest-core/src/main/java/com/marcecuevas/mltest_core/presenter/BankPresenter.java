package com.marcecuevas.mltest_core.presenter;

import com.marcecuevas.mltest_core.model.SelectionModel;
import com.marcecuevas.mltest_core.model.dto.BankDTO;
import com.marcecuevas.mltest_core.presenter.common.BasePresenter;
import com.marcecuevas.mltest_core.viewModel.BankView;

import java.util.List;

public interface BankPresenter extends BasePresenter<BankView> {

    void banks(SelectionModel selection);

}

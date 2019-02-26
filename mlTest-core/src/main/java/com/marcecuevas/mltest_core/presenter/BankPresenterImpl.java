package com.marcecuevas.mltest_core.presenter;

import com.marcecuevas.mltest_core.dao.PaymentDAO;
import com.marcecuevas.mltest_core.model.MLError;
import com.marcecuevas.mltest_core.model.MLResultListener;
import com.marcecuevas.mltest_core.model.SelectionModel;
import com.marcecuevas.mltest_core.model.dto.BankDTO;
import com.marcecuevas.mltest_core.presenter.common.BasePresenter;
import com.marcecuevas.mltest_core.viewModel.BankView;
import com.marcecuevas.mltest_core.viewModel.HomeView;
import com.marcecuevas.mltest_core.viewModel.PaymentView;

import java.util.List;

import javax.inject.Inject;

public class BankPresenterImpl implements BankPresenter {

    @Inject
    protected PaymentDAO dao;

    private BankView view;

    @Inject
    public BankPresenterImpl(){

    }

    @Override
    public void bind(BankView view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }

    @Override
    public void banks(SelectionModel selection) {
        dao.banks(new MLResultListener<List<BankDTO>>() {
            @Override
            public void success(List<BankDTO> result) {
                if(result.isEmpty()){
                    view.showEmptyState();
                }else{
                    view.showBanks(result);
                }
            }

            @Override
            public void error(MLError error) {
                view.showError(MLError.errorFromMessageAndTitle("Ha ocurrido un error.","ERROR"));
            }
        },selection.getPaymentID());
    }
}

package com.marcecuevas.mltest_core.presenter;

import com.marcecuevas.mltest_core.dao.PaymentDAO;
import com.marcecuevas.mltest_core.model.MLError;
import com.marcecuevas.mltest_core.model.MLResultListener;
import com.marcecuevas.mltest_core.model.dto.PaymentMethodDTO;
import com.marcecuevas.mltest_core.viewModel.PaymentView;

import java.util.List;

import javax.inject.Inject;

public class PaymentPresenterImpl implements PaymentPresenter {

    @Inject
    protected PaymentDAO dao;

    private PaymentView view;

    @Inject
    public PaymentPresenterImpl(){

    }
    @Override
    public void paymentMethods() {
        dao.paymentMethods(new MLResultListener<List<PaymentMethodDTO>>() {
            @Override
            public void success(List<PaymentMethodDTO> result) {
                if(result.isEmpty()){
                    view.showEmptyState();
                }else{
                    view.showPaymentMethods(result);
                }
            }

            @Override
            public void error(MLError error) {

            }
        });
    }

    @Override
    public void bind(PaymentView view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }
}

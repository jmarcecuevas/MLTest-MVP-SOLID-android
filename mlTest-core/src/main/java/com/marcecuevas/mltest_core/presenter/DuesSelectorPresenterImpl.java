package com.marcecuevas.mltest_core.presenter;

import com.marcecuevas.mltest_core.dao.PaymentDAO;
import com.marcecuevas.mltest_core.model.MLError;
import com.marcecuevas.mltest_core.model.MLResultListener;
import com.marcecuevas.mltest_core.model.SelectionModel;
import com.marcecuevas.mltest_core.model.dto.InstallmentOptionDTO;
import com.marcecuevas.mltest_core.viewModel.DuesView;
import com.marcecuevas.mltest_core.viewModel.PaymentView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DuesSelectorPresenterImpl implements DuesSelectorPresenter {

    @Inject
    protected PaymentDAO dao;

    private DuesView view;

    @Inject
    public DuesSelectorPresenterImpl(){

    }

    @Override
    public void installmentOptions(SelectionModel selection,String installments) {
        dao.installmentOptions(new MLResultListener<List<InstallmentOptionDTO>>() {
            @Override
            public void success(List<InstallmentOptionDTO> result) {
                List<InstallmentOptionDTO> items = new ArrayList<>();
                items.add(installmentOptionsBy(selection.getBankID(),result));
                String message = recommendedMessage(items.get(0),installments);
                view.showDetails(message);
            }

            @Override
            public void error(MLError error) {
                view.showError(MLError.errorFromMessageAndTitle("Ha ocurrido un error.","ERROR"));
            }
        },selection.getTotal(),selection.getPaymentID(),selection.getBankID());
    }

    private InstallmentOptionDTO installmentOptionsBy(String issuerID,
                                                         List<InstallmentOptionDTO> items){
        InstallmentOptionDTO installmentOption = new InstallmentOptionDTO();
        for(InstallmentOptionDTO installment : items){
            if(installment.getIssuer().getId().equals(issuerID)){
                return installment;
            }
        }
        return installmentOption;
    }

    private String recommendedMessage(InstallmentOptionDTO item, String installments) {
        for(InstallmentOptionDTO.PayerCostDTO payerCost : item.getPayerCosts()){
            if(payerCost.getInstallments() == Integer.valueOf(installments)){
                return payerCost.getRecommendedMessage();
            }
        }
        return "";
    }

    @Override
    public void bind(DuesView view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }
}

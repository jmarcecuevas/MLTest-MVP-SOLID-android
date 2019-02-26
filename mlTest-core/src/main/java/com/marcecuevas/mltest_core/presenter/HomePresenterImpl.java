package com.marcecuevas.mltest_core.presenter;

import com.marcecuevas.mltest_core.dao.PaymentDAO;
import com.marcecuevas.mltest_core.model.MLError;
import com.marcecuevas.mltest_core.model.SelectionModel;
import com.marcecuevas.mltest_core.viewModel.HomeView;

import javax.inject.Inject;

public class HomePresenterImpl implements HomePresenter {

    private HomeView view;

    @Inject
    public HomePresenterImpl(){

    }

    @Override
    public void handleInput(String input) {
        SelectionModel selection = new SelectionModel();
        if(input.isEmpty()){
            view.showError(MLError.errorFromMessage("Debes ingresar un monto."));
        }else{
            selection.setTotal(input);
            view.goToPaymentMethodSelector(selection);
        }
    }

    @Override
    public void bind(HomeView view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }
}

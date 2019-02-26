package com.marcecuevas.mlmoduletest.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import com.marcecuevas.mlmoduletest.R;
import com.marcecuevas.mlmoduletest.main.MLApplication;
import com.marcecuevas.mlmoduletest.ui.activity.PaymentMethodActivity;
import com.marcecuevas.mlmoduletest.ui.custom.AutoResizeEditText;
import com.marcecuevas.mlmoduletest.ui.fragment.common.BaseFragment;
import com.marcecuevas.mlmoduletest.utils.MLFont;
import com.marcecuevas.mlmoduletest.utils.MLFontVariable;
import com.marcecuevas.mltest_core.di.module.HomeModule;
import com.marcecuevas.mltest_core.model.MLError;
import com.marcecuevas.mltest_core.model.SelectionModel;
import com.marcecuevas.mltest_core.presenter.HomePresenter;
import com.marcecuevas.mltest_core.viewModel.HomeView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment implements HomeView {

    @Inject
    protected HomePresenter presenter;

    @Inject
    protected Context context;

    @BindView(R.id.amountET)
    protected AutoResizeEditText amountET;

    @BindView(R.id.continueBTN)
    protected Button continueBTN;


    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void injectDependencies(MLApplication application) {
        application
                .getComponent()
                .plus(new HomeModule())
                .inject(this);
    }

    @Override
    protected void init() {
        MLFont.applyFont(getContext(),amountET, MLFontVariable.bold);

        continueBTN.setTextColor(Color.WHITE);
        continueBTN.setTextSize(18);
        MLFont.applyFont(getContext(),continueBTN, MLFontVariable.light);
    }

    @OnClick(R.id.continueBTN)
    public void onClick(View view){
        presenter.handleInput(amountET.getText().toString());
    }

    @Override
    public void goToPaymentMethodSelector(SelectionModel item) {
        Intent intent = new Intent(getContext(), PaymentMethodActivity.class);
        intent.putExtra("SELECTION_MODEL",item);
        startActivity(intent);
    }

    @Override
    public void showError(MLError error) {
        showErrorMessage(error);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter.bind(this);
    }
}

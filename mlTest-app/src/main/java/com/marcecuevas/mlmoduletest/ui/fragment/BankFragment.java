package com.marcecuevas.mlmoduletest.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.marcecuevas.mlmoduletest.R;
import com.marcecuevas.mlmoduletest.main.MLApplication;
import com.marcecuevas.mlmoduletest.ui.activity.DuesSelectorActivity;
import com.marcecuevas.mlmoduletest.ui.adapter.BankAdapter;
import com.marcecuevas.mlmoduletest.ui.fragment.common.BaseFragment;
import com.marcecuevas.mltest_core.di.module.PaymentModule;
import com.marcecuevas.mltest_core.model.MLError;
import com.marcecuevas.mltest_core.model.SelectionModel;
import com.marcecuevas.mltest_core.model.dto.BankDTO;
import com.marcecuevas.mltest_core.presenter.BankPresenter;
import com.marcecuevas.mltest_core.viewModel.BankView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class BankFragment extends BaseFragment implements BankView, BankAdapter.Listener {

    @Inject
    protected BankPresenter presenter;

    @BindView(R.id.banksRV)
    protected RecyclerView methodsRV;

    @BindView(R.id.emptyLottieView)
    protected LottieAnimationView emptyLottieView;

    @BindView(R.id.lottieAnimation)
    protected LottieAnimationView lottieAnimation;

    @BindView(R.id.container)
    protected ConstraintLayout container;

    private BankAdapter adapter;
    private SelectionModel selectionModel;

    @Override
    protected int getLayout() {
        return R.layout.fragment_bank;
    }

    @Override
    protected void injectDependencies(MLApplication application) {
        application.getComponent()
                .plus(new PaymentModule())
                .inject(this);
    }

    @Override
    protected void init() {
        loadExtras();

        adapter = new BankAdapter(getContext(), this);
        methodsRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        methodsRV.setAdapter(adapter);

        presenter.banks(selectionModel);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter.bind(this);
    }

    private void loadExtras(){
        if(getActivity() != null && getActivity().getIntent() != null){
            selectionModel = (SelectionModel) getActivity().getIntent().
                    getSerializableExtra("SELECTION_MODEL");
        }
    }

    @Override
    public void showBanks(List<BankDTO> items) {
        lottieAnimation.setVisibility(View.VISIBLE);
        adapter.update(items);
    }

    @Override
    public void showEmptyState() {
        container.setVisibility(View.GONE);
        emptyLottieView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(MLError error) {
        showErrorMessage(error);
    }

    @Override
    public void onBankSelected(BankDTO bank) {
        selectionModel.setBankName(bank.getName());
        selectionModel.setBankID(bank.getId());
        Intent intent = new Intent(getContext(), DuesSelectorActivity.class);
        intent.putExtra("SELECTION_MODEL",selectionModel);
        startActivity(intent);
    }
}

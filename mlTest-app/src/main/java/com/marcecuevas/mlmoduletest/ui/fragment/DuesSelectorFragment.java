package com.marcecuevas.mlmoduletest.ui.fragment;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.marcecuevas.mlmoduletest.R;
import com.marcecuevas.mlmoduletest.main.MLApplication;
import com.marcecuevas.mlmoduletest.ui.activity.HomeActivity;
import com.marcecuevas.mlmoduletest.ui.fragment.common.BaseFragment;
import com.marcecuevas.mlmoduletest.utils.MLFont;
import com.marcecuevas.mlmoduletest.utils.MLFontVariable;
import com.marcecuevas.mltest_core.di.module.PaymentModule;
import com.marcecuevas.mltest_core.model.MLError;
import com.marcecuevas.mltest_core.model.SelectionModel;
import com.marcecuevas.mltest_core.presenter.DuesSelectorPresenter;
import com.marcecuevas.mltest_core.viewModel.DuesView;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class DuesSelectorFragment extends BaseFragment implements DuesView, DetailDialogFragment.Listener {

    @Inject
    protected DuesSelectorPresenter presenter;

    @BindView(R.id.numberPicker)
    protected NumberPicker numberPicker;

    @BindView(R.id.finishBTN)
    protected Button finishBTN;

    private String[] installmentNumbers = {"1","3","6","9","12"};
    private SelectionModel selectionModel;

    @Override
    protected int getLayout() {
        return R.layout.fragment_due_selector;
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

        numberPicker.setDisplayedValues(installmentNumbers);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(installmentNumbers.length - 1);

        finishBTN.setTextColor(Color.WHITE);
        finishBTN.setTextSize(18);
        finishBTN.setText(getString(R.string.finish_label));
        MLFont.applyFont(getContext(),finishBTN, MLFontVariable.light);
    }

    @OnClick(R.id.finishBTN)
    public void onClick(View view){
        presenter.installmentOptions(selectionModel,installmentNumbers[numberPicker.getValue()]);
    }

    private void loadExtras(){
        if(getActivity() != null && getActivity().getIntent() != null){
            selectionModel = (SelectionModel) getActivity().getIntent().
                    getSerializableExtra("SELECTION_MODEL");
        }
    }

    @Override
    public void showDetails(String message) {
        FragmentManager fm = Objects.requireNonNull(getActivity()).getFragmentManager();
        DetailDialogFragment fragment = DetailDialogFragment.newInstance(selectionModel,message);
        fragment.setListener(this);
        fragment.show(fm,"DIALOG");
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

    @Override
    public void onFinish() {
        Intent intent = new Intent(getContext(), HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

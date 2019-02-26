package com.marcecuevas.mlmoduletest.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.marcecuevas.mlmoduletest.R;
import com.marcecuevas.mlmoduletest.main.MLApplication;
import com.marcecuevas.mlmoduletest.ui.activity.BankActivity;
import com.marcecuevas.mlmoduletest.ui.adapter.PaymentMethodAdapter;
import com.marcecuevas.mlmoduletest.ui.fragment.common.BaseFragment;
import com.marcecuevas.mlmoduletest.utils.MLFont;
import com.marcecuevas.mlmoduletest.utils.MLFontVariable;
import com.marcecuevas.mltest_core.di.module.PaymentModule;
import com.marcecuevas.mltest_core.model.MLError;
import com.marcecuevas.mltest_core.model.SelectionModel;
import com.marcecuevas.mltest_core.model.dto.PaymentMethodDTO;
import com.marcecuevas.mltest_core.presenter.PaymentPresenter;
import com.marcecuevas.mltest_core.viewModel.PaymentView;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;

public class PaymentMethodFragment extends BaseFragment implements PaymentView, PaymentMethodAdapter.Listener {

    @Inject
    protected PaymentPresenter presenter;

    @BindView(R.id.methodsRV)
    protected RecyclerView methodsRV;

    @BindView(R.id.totalTV)
    protected TextView totalTV;

    @BindView(R.id.totalAmountTV)
    protected TextView totalAmountTV;

    private SelectionModel selectionModel;
    private PaymentMethodAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_payment_method;
    }

    @Override
    protected void injectDependencies(MLApplication application) {
        application.getComponent()
                    .plus(new PaymentModule())
                    .inject(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void init() {
        loadExtra();

        totalTV.setText(getString(R.string.total_label));
        totalTV.setTextSize(14);
        totalTV.setTextColor(getResources().getColor(R.color.colorDark));
        MLFont.applyFont(getContext(),totalTV, MLFontVariable.light);

        totalAmountTV.setText("$" + selectionModel.getTotal());
        totalAmountTV.setTextSize(16);
        totalAmountTV.setTextColor(getResources().getColor(R.color.colorDark));
        MLFont.applyFont(getContext(),totalAmountTV,MLFontVariable.bold);

        adapter = new PaymentMethodAdapter(getContext(),this);
        methodsRV.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        methodsRV.setAdapter(adapter);

        presenter.paymentMethods();
    }

    private void loadExtra(){
        if(getActivity() != null && getActivity().getIntent() != null){
            selectionModel = (SelectionModel) getActivity().getIntent().
                    getSerializableExtra("SELECTION_MODEL");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter.bind(this);
    }

    @Override
    public void onPaymentMethodSelected(PaymentMethodDTO payment) {
        selectionModel.setPaymentName(payment.getName());
        selectionModel.setPaymentID(payment.getId());
        Intent intent = new Intent(getContext(),BankActivity.class);
        intent.putExtra("SELECTION_MODEL",selectionModel);
        startActivity(intent);
    }

    @Override
    public void showPaymentMethods(List<PaymentMethodDTO> items) {
        adapter.update(items);
    }

    @Override
    public void showEmptyState() {

    }

    @Override
    public void showError(MLError error) {

    }

    @Override
    public void showOfflineMessage(boolean isCritical) {

    }
}

package com.marcecuevas.mlmoduletest.ui.fragment;

import android.content.Context;
import android.widget.Toast;

import com.marcecuevas.mlmoduletest.R;
import com.marcecuevas.mlmoduletest.main.MLApplication;
import com.marcecuevas.mlmoduletest.ui.fragment.common.BaseFragment;
import com.marcecuevas.mltest_core.di.module.login.LoginModule;
import com.marcecuevas.mltest_core.model.login.UserDTO;
import com.marcecuevas.mltest_core.presenter.login.LoginPresenter;
import com.marcecuevas.mltest_core.viewModel.LoginView;

import javax.inject.Inject;

public class MainFragment extends BaseFragment implements LoginView {

    @Inject
    protected LoginPresenter presenter;
    @Inject
    protected Context context;

    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void injectDependencies(MLApplication application) {
        application
                .getComponent()
                .plus(new LoginModule())
                .inject(this);
    }

    @Override
    protected void init() {
        presenter.login("ASD","ASD");
    }

    @Override
    public void showUser(UserDTO user) {
        Toast.makeText(context,"Algo",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showOfflineMessage(boolean isCritical) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter.bind(this);
    }
}

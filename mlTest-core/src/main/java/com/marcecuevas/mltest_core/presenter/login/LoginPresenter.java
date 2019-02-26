package com.marcecuevas.mltest_core.presenter.login;

import com.marcecuevas.mltest_core.presenter.common.BaseaPresenter;
import com.marcecuevas.mltest_core.viewModel.LoginView;

public interface LoginPresenter extends BaseaPresenter<LoginView> {
    void login(String userName, String pass);
}

package com.marcecuevas.mltest_core.presenter.login;

import com.marcecuevas.mltest_core.dao.login.LoginDAO;
import com.marcecuevas.mltest_core.model.MLError;
import com.marcecuevas.mltest_core.model.login.UserDTO;
import com.marcecuevas.mltest_core.util.MLResultListener;
import com.marcecuevas.mltest_core.viewModel.LoginView;

import javax.inject.Inject;

public class LoginPresenterImp implements LoginPresenter{

    @Inject
    protected LoginDAO loginDAO;
    private LoginView view;

    @Inject
    public LoginPresenterImp(){

    }

    @Override
    public void login(String userName, String pass) {
        loginDAO.login("asd", "AD", new MLResultListener<UserDTO>() {
            @Override
            public void success(UserDTO result) {
                view.showMessage(result.getName());
            }

            @Override
            public void error(MLError error) {
                view.showMessage(error.getMessage());
            }
        });
    }

    @Override
    public void bind(LoginView view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        view = null;
    }
}

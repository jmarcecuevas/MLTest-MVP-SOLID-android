package com.marcecuevas.mltest_core.viewModel;

import com.marcecuevas.mltest_core.model.login.UserDTO;
import com.marcecuevas.mltest_core.viewModel.common.BaseView;

public interface LoginView extends BaseView {

    void showUser(UserDTO user);
}

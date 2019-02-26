package com.marcecuevas.mltest_core.dao.login;


import com.marcecuevas.mltest_core.model.login.UserDTO;
import com.marcecuevas.mltest_core.util.MLResultListener;

public interface LoginDAO {

    void login(String userName, String pass, MLResultListener<UserDTO> listener);
}

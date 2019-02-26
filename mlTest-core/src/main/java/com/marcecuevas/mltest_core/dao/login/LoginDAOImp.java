package com.marcecuevas.mltest_core.dao.login;

import com.marcecuevas.mltest_core.dao.common.MLCallback;
import com.marcecuevas.mltest_core.di.scope.LoginScope;
import com.marcecuevas.mltest_core.model.MLError;
import com.marcecuevas.mltest_core.model.login.UserDTO;
import com.marcecuevas.mltest_core.util.MLResultListener;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

@LoginScope
public class LoginDAOImp implements LoginDAO {

    @Inject
    protected Retrofit retrofit;

    @Inject
    public LoginDAOImp(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    @Override
    public void login(String userName, String pass, MLResultListener<UserDTO> listener) {
        LoginREST loginREST = retrofit.create(LoginREST.class);
        Call<UserDTO> call = loginREST.getUser();
        call.enqueue(new MLCallback<>(new MLResultListener<UserDTO>() {
            @Override
            public void success(UserDTO result) {
                listener.success(result);
            }

            @Override
            public void error(MLError error) {
                listener.error(error);
            }
        },retrofit));
    }

    private interface LoginREST {
        @GET("5bad37623300005b000eb56a")
        Call<UserDTO> getUser();
    }
}

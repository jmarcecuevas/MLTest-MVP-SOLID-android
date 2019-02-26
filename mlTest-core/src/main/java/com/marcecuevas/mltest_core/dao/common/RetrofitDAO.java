package com.marcecuevas.mltest_core.dao.common;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Retrofit;

@Singleton
public class RetrofitDAO extends GenericDAO {

    @Inject
    Retrofit retrofit;

    @Singleton
    public RetrofitDAO(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}

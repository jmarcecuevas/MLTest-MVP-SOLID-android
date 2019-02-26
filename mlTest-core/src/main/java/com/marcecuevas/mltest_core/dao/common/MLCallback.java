package com.marcecuevas.mltest_core.dao.common;

import com.marcecuevas.mltest_core.model.MLError;
import com.marcecuevas.mltest_core.util.MLResultListener;
import java.lang.annotation.Annotation;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MLCallback<T> implements Callback<T> {

    private MLResultListener<T> listener;
    private Retrofit retrofit;

    public MLCallback(MLResultListener<T> listener, Retrofit retrofit){
        this.listener = listener;
        this.retrofit = retrofit;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if(!response.isSuccessful()){
            try {
                Converter<ResponseBody, MLError> errorConverter = retrofit.responseBodyConverter(MLError.class, new Annotation[0]);
                MLError error = errorConverter.convert(response.errorBody());
                listener.error(error);
            }catch (Exception e){
                e.printStackTrace();
            }
            return;
        }
        listener.success(response.body());
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        listener.error(new MLError());
    }
}

package com.marcecuevas.mltest_core.dao;

import com.marcecuevas.mltest_core.dao.common.MLCallback;
import com.marcecuevas.mltest_core.model.MLError;
import com.marcecuevas.mltest_core.model.MLResultListener;
import com.marcecuevas.mltest_core.model.dto.BankDTO;
import com.marcecuevas.mltest_core.model.dto.InstallmentOptionDTO;
import com.marcecuevas.mltest_core.model.dto.PaymentMethodDTO;
import com.marcecuevas.mltest_core.util.Constants;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class PaymentDAOImpl implements PaymentDAO {

    @Inject
    protected Retrofit retrofit;

    @Inject
    public PaymentDAOImpl(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    @Override
    public void paymentMethods(final MLResultListener<List<PaymentMethodDTO>> listener){
        PaymentREST paymentREST = retrofit.create(PaymentREST.class);
        Call<List<PaymentMethodDTO>> call = paymentREST.paymentMethods(Constants.PUBLIC_KEY);

        call.enqueue(new MLCallback<>(new MLResultListener<List<PaymentMethodDTO>>() {
            @Override
            public void success(List<PaymentMethodDTO> result) {
                listener.success(result);
            }

            @Override
            public void error(MLError error) {
                listener.error(error);
            }
        },retrofit));
    }

    @Override
    public void banks(final MLResultListener<List<BankDTO>> listener, String paymentMethodID){
        PaymentREST paymentREST = retrofit.create(PaymentREST.class);
        Call<List<BankDTO>> call = paymentREST.banks(Constants.PUBLIC_KEY,paymentMethodID);

        call.enqueue(new MLCallback<>(new MLResultListener<List<BankDTO>>() {
            @Override
            public void success(List<BankDTO> result) {
                listener.success(result);
            }

            @Override
            public void error(MLError error) {
                listener.error(error);
            }
        },retrofit));
    }

    @Override
    public void installmentOptions(final MLResultListener<List<InstallmentOptionDTO>> listener, String amount,
                                   String paymentMethodID,String issuerID){
        PaymentREST paymentREST = retrofit.create(PaymentREST.class);
        Call<List<InstallmentOptionDTO>> call = paymentREST.installmentOptions(Constants.PUBLIC_KEY,amount,
                paymentMethodID,issuerID);

        call.enqueue(new MLCallback<>(new MLResultListener<List<InstallmentOptionDTO>>() {
            @Override
            public void success(List<InstallmentOptionDTO> result) {
                listener.success(result);
            }

            @Override
            public void error(MLError error) {
                listener.error(error);
            }
        },retrofit));
    }

    private interface PaymentREST {

        @GET("payment_methods")
        Call<List<PaymentMethodDTO>> paymentMethods(@Query("public_key") String publicKey);

        @GET("payment_methods/card_issuers")
        Call<List<BankDTO>> banks(@Query("public_key") String publicKey,
                                  @Query("payment_method_id") String paymentMethodID);

        @GET("payment_methods/installments")
        Call<List<InstallmentOptionDTO>> installmentOptions(@Query("public_key") String publicKey,
                                                            @Query("amount") String amount,
                                                            @Query("payment_method_id") String paymentMethodID,
                                                            @Query("issuer_id") String issuerID);
    }
}

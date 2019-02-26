package com.marcecuevas.mltest_core.dao;

import com.marcecuevas.mltest_core.model.MLResultListener;
import com.marcecuevas.mltest_core.model.dto.BankDTO;
import com.marcecuevas.mltest_core.model.dto.InstallmentOptionDTO;
import com.marcecuevas.mltest_core.model.dto.PaymentMethodDTO;

import java.util.List;

public interface PaymentDAO {

    void paymentMethods(final MLResultListener<List<PaymentMethodDTO>> listener);

    void banks(final MLResultListener<List<BankDTO>> listener, String paymentMethodID);

    void installmentOptions(final MLResultListener<List<InstallmentOptionDTO>> listener, String amount,
                            String paymentMethodID, String issuerID);

}

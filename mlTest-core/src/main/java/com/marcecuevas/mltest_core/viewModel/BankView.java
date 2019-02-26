package com.marcecuevas.mltest_core.viewModel;

import com.marcecuevas.mltest_core.model.dto.BankDTO;
import com.marcecuevas.mltest_core.viewModel.common.BaseView;

import java.util.List;

public interface BankView extends BaseView {

    void showBanks(List<BankDTO> items);
}

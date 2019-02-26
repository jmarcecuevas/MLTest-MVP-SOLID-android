package com.marcecuevas.mltest_core.presenter;

import com.marcecuevas.mltest_core.presenter.common.BasePresenter;
import com.marcecuevas.mltest_core.viewModel.HomeView;

public interface HomePresenter extends BasePresenter<HomeView> {

    void handleInput(String input);
}

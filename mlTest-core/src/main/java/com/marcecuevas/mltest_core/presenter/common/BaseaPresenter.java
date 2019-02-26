package com.marcecuevas.mltest_core.presenter.common;

public interface BaseaPresenter<T>{

    void bind(T view);
    void unbind();
}

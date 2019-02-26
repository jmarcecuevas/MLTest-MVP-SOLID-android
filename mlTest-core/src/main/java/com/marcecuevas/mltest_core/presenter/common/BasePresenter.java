package com.marcecuevas.mltest_core.presenter.common;

public interface BasePresenter<T>{

    void bind(T view);
    void unbind();
}

package com.marcecuevas.mltest_core.presenter.common;

public class BasePresenter<T>{

    private T view;

    public BasePresenter(T view){
        this.view = view;
    }

    public T getView() {
        return view;
    }

    public void detachView(){
        view = null;
    }
}
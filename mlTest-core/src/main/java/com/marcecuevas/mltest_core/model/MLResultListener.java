package com.marcecuevas.mltest_core.model;

public interface MLResultListener<T> {

    void success(T result);
    void error(MLError error);
}

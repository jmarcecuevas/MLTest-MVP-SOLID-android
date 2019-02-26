package com.marcecuevas.mltest_core.util;

import com.marcecuevas.mltest_core.model.MLError;

public interface MLResultListener<T> {
    void success(T result);
    void error(MLError error);
}

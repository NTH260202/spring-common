package com.example.rest.model.response;

import com.thanhha.exception.InvalidException;

public interface ResponseWrapper<T> {
    /**
     * Data
     *
     * @return data
     */
    T getData();

    /**
     * Success
     *
     * @return success
     * @throws InvalidException invalid
     */
    boolean isSuccess() throws InvalidException;
}

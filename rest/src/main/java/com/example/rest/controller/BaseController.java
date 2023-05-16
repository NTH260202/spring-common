package com.example.rest.controller;

import com.example.rest.factory.IDataService;
import com.example.rest.factory.IResponseService;
import com.example.rest.model.IModel;
import com.example.rest.model.response.BaseResponse;
import com.thanhha.exception.InvalidException;
import com.thanhha.exception.RestException;
import org.springframework.http.ResponseEntity;

public abstract class BaseController<I, T extends IModel<I>, U extends T> {
    protected final IDataService<I, T, U> iDataService;
    protected final IResponseService iResponseService;

    protected BaseController(IDataService<I, T, U> iDataService, IResponseService iResponseService) {
        this.iDataService = iDataService;
        this.iResponseService = iResponseService;
    }

    protected ResponseEntity<BaseResponse<U>> factoryCreateModel(U request) {
        try {
            U response = iDataService.createModel(request);
            return iResponseService.success(response);
        } catch (InvalidException e) {
            throw RestException.create(e);
        }
    }
}

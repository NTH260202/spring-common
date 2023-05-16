package com.example.rest.factory.impl;

import com.example.rest.factory.IDataService;
import com.example.rest.model.IModel;
import com.thanhha.exception.InvalidException;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseDataService<I, T extends IModel<I>, D extends T> implements IDataService<I, T, D> {
    @Override
    public D createModel(D detail) throws InvalidException {
        detail = aroundCreate(preCreate(detail));
//        cachePutCreate(detail);
        return detail;
    }

    protected D preCreate(D detail) throws InvalidException {
        return detail;
    }

    protected abstract D aroundCreate(D detail) throws InvalidException;
}

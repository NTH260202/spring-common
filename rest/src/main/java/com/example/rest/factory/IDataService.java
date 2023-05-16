package com.example.rest.factory;

import com.example.rest.model.IModel;
import com.example.rest.model.impl.BaseModel;
import com.thanhha.exception.InvalidException;

import java.io.Serializable;

public interface IDataService<I, T extends IModel<I>, U extends T> {
    U createModel(U detail) throws InvalidException;
    boolean existByDetail(U detail) throws InvalidException;
}

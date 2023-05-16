package com.example.rest.factory.impl;

import com.example.rest.factory.IPersistDataService;
import com.example.rest.model.IModel;
import com.thanhha.exception.InvalidException;
import org.springframework.data.repository.PagingAndSortingRepository;

public abstract class BasePersistDataService<I, T extends IModel<I>, D extends T, A, E>
    extends BaseDataService<I, T, D> implements IPersistDataService<T, D, E> {
    protected final PagingAndSortingRepository<E, A> repository;

    protected BasePersistDataService(PagingAndSortingRepository<E, A> repository) {
        this.repository = repository;
    }

    @Override
    protected D preCreate(D detail) throws InvalidException {
        if (existByDetail(detail)) {
            //TODO: pass ErrorCode
            throw new InvalidException();
        }
        return detail;
    }

    @Override
    protected D aroundCreate(D detail) throws InvalidException {
        E entity = repository.save(createConvertToEntity(detail));
        postCreate(entity, detail);
        return convertToDetail(entity);
    }

    protected void postCreate(E entity, D detail) throws InvalidException {
    }

    @Override
    public boolean existByDetail(D detail) throws InvalidException {
        if (detail.getId() != null) {
            return repository.existsById(convertId(detail.getId()));
        }
        return false;
    }

    protected A convertId(I id) throws InvalidException {
        try {
            return (A) id;
        } catch (ClassCastException e) {
            //TODO: pass ErrorCode
            throw new InvalidException();
        }
    }
}

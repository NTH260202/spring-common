package com.example.rest.factory;

import com.thanhha.exception.InvalidException;

public interface IPersistDataService<T, D, E> {
    /**
     * Convert detail to entity when create
     *
     * @param detail detail model
     * @return entity
     * @throws InvalidException invalid
     */
    E createConvertToEntity(D detail) throws InvalidException;

    /**
     * Convert detail to entity when update
     *
     * @param entity old entity
     * @param detail detail
     * @throws InvalidException invalid
     */
    void updateConvertToEntity(E entity, D detail) throws InvalidException;

    /**
     * Convert entity to detail model
     *
     * @param entity entity
     * @return detail model
     * @throws InvalidException invalid
     */
    D convertToDetail(E entity) throws InvalidException;

    /**
     * Convert entity to info model
     *
     * @param entity entity
     * @return info model
     * @throws InvalidException invalid
     */
    T convertToInfo(E entity) throws InvalidException;
}

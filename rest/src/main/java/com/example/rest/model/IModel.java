package com.example.rest.model;

import java.io.Serializable;

/**
 *
 * @param <T> id type
 */
public interface IModel<T> extends Serializable {
    T getId();
}

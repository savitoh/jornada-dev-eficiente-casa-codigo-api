package com.savitoh.casacodigoapi.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericService <T extends Serializable, Id extends Serializable> {

    T save(T object);

    Optional<T> getById(Id id);

    void delete(T object);

    List<T> getAll();
}

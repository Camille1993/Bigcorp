package com.training.bigcorp.bigcorp.repository;

import java.util.List;

public interface CrudDao<T, ID> {

    void persist(T element);

    //Read
    T findById(ID id);

    List<T> findAll();

    //Delete
    void delete(T id);
}

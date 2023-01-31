package com.example.carlocation.services;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public interface CrudService<TEntity, TKey extends Serializable>{

    TEntity save(TEntity entity);

    Stream<TEntity> readAll();

    Optional<TEntity> readOneByKey(TKey id);

    void delete(TKey id);
}

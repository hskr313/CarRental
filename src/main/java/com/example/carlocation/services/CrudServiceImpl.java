package com.example.carlocation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class CrudServiceImpl<Repository extends JpaRepository,
        TEntity,
        TKey extends Serializable>
        implements CrudService<TEntity, TKey> {

    protected final Repository repository;

    public CrudServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public TEntity save(TEntity entity) {
        return (TEntity) this.repository.save(entity);
    }

    @Override
    public Stream<TEntity> readAll() {
        return this.repository.findAll().stream();
    }

    @Override
    public Optional<TEntity> readOneByKey(TKey id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(TKey id) {
        this.repository.deleteById(id);
    }
}

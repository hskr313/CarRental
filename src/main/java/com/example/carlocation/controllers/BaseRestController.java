package com.example.carlocation.controllers;

import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface BaseRestController <TEntity, TKey>{

    ResponseEntity<TEntity> readOne(TKey id);

    ResponseEntity<Collection<TEntity>> readAll();

}

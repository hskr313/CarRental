package com.example.carlocation.services.model;

import com.example.carlocation.models.entities.Model;
import com.example.carlocation.repositories.ModelRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl extends CrudServiceImpl<ModelRepository, Model, Long>
        implements ModelService {

    public ModelServiceImpl(ModelRepository repository) {
        super(repository);
    }
}

package com.example.carlocation.services.model;

import com.example.carlocation.models.entities.Model;
import com.example.carlocation.repositories.ModelRepository;
import com.example.carlocation.repositories.OptionRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl extends CrudServiceImpl<ModelRepository, Model, Long>
        implements ModelService {

    private final OptionRepository optionRepository;

    public ModelServiceImpl(ModelRepository repository, OptionRepository optionRepository) {
        super(repository);
        this.optionRepository = optionRepository;
    }

    @Override
    public Model save(Model model) {
        this.optionRepository.saveAll(model.getOptions());
        return super.save(model);
    }
}

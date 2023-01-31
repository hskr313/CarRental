package com.example.carlocation.services.option;

import com.example.carlocation.models.entities.Option;
import com.example.carlocation.repositories.OptionRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OptionServiceImpl extends CrudServiceImpl<OptionRepository, Option, Long>
        implements OptionService {

    public OptionServiceImpl(OptionRepository repository) {
        super(repository);
    }
}

package com.example.carlocation.services.fin;

import com.example.carlocation.models.entities.Fin;
import com.example.carlocation.repositories.FinRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class FinServiceImpl extends CrudServiceImpl<FinRepository,Fin, Long> implements FinService {

    public FinServiceImpl(FinRepository repository) {
        super(repository);
    }
}

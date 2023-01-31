package com.example.carlocation.services.tarificationClass;

import com.example.carlocation.models.entities.TarificationClass;
import com.example.carlocation.repositories.TarificationClassRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TarificationClassServiceImpl extends CrudServiceImpl<TarificationClassRepository, TarificationClass, Long>
        implements TartificationClassService {

    public TarificationClassServiceImpl(TarificationClassRepository repository) {
        super(repository);
    }
}

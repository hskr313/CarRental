package com.example.carlocation.services.pricingClass;

import com.example.carlocation.models.entities.PricingClass;
import com.example.carlocation.repositories.PricingClassRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PricingClassServiceImpl extends CrudServiceImpl<PricingClassRepository, PricingClass, Long>
        implements PricingClassService {

    public PricingClassServiceImpl(PricingClassRepository repository) {
        super(repository);
    }
}

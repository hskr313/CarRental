package com.example.carlocation.services.insurance;

import com.example.carlocation.models.entities.Insurance;
import com.example.carlocation.repositories.InsuranceRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl extends CrudServiceImpl<InsuranceRepository, Insurance, Long>
        implements InsuranceService{

    public InsuranceServiceImpl(InsuranceRepository repository) {
        super(repository);
    }
}

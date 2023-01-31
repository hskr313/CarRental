package com.example.carlocation.services.insuranceContract;

import com.example.carlocation.models.entities.InsuranceContract;
import com.example.carlocation.repositories.InsuranceContractRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class InsuranceContractServiceImpl extends CrudServiceImpl<InsuranceContractRepository, InsuranceContract, Long>
        implements InsuranceContractService {

    public InsuranceContractServiceImpl(InsuranceContractRepository repository) {
        super(repository);
    }
}

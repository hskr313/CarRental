package com.example.carlocation.services.rentalFormula;

import com.example.carlocation.models.entities.RentalFormula;
import com.example.carlocation.repositories.RentalFormulaRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RentalFormulaServiceImpl extends CrudServiceImpl<RentalFormulaRepository, RentalFormula, Long>
        implements RentalFormulaService {

    public RentalFormulaServiceImpl(RentalFormulaRepository repository) {
        super(repository);
    }
}

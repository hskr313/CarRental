package com.example.carlocation.services.tarificationFormula;

import com.example.carlocation.models.entities.TarificationFormula;
import com.example.carlocation.repositories.TarificationFormulaRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TarificationFormulaServiceImpl extends CrudServiceImpl<TarificationFormulaRepository, TarificationFormula, Long>
        implements TarificationFormulaService {

    public TarificationFormulaServiceImpl(TarificationFormulaRepository repository) {
        super(repository);
    }
}

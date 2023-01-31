package com.example.carlocation.services.rental;

import com.example.carlocation.models.entities.Rental;
import com.example.carlocation.repositories.RentalRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RentalServiceImpl extends CrudServiceImpl<RentalRepository, Rental, Long> implements RentalService {

    public RentalServiceImpl(RentalRepository repository) {
        super(repository);
    }
}

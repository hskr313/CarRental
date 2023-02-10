package com.example.carlocation.services.customer;

import com.example.carlocation.models.entities.Customer;
import com.example.carlocation.repositories.CustomerRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends CrudServiceImpl<CustomerRepository, Customer, Long>
        implements CustomerService {

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}

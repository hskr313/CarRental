package com.example.carlocation.services.client;

import com.example.carlocation.models.entities.Client;
import com.example.carlocation.repositories.ClientRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends CrudServiceImpl<ClientRepository, Client, Long>
        implements ClientService{

    public ClientServiceImpl(ClientRepository repository) {
        super(repository);
    }
}

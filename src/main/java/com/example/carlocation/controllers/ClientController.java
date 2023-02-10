package com.example.carlocation.controllers;

import com.example.carlocation.exceptions.HttpNotFoundException;
import com.example.carlocation.exceptions.HttpPreconditionFailedException;
import com.example.carlocation.models.dtos.client.ClientDTO;
import com.example.carlocation.models.entities.Client;
import com.example.carlocation.models.forms.ClientAddForm;
import com.example.carlocation.services.client.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = {"/client"})
public class ClientController implements BaseRestController<ClientDTO, Long>{

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "")
    public ResponseEntity<Collection<ClientDTO>> readAll(){
        return ResponseEntity.ok(this.clientService.readAll()
                .map(ClientDTO::toDTO)
                .toList());
    }

    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<ClientDTO> readOne(@PathVariable Long id){

        Client client = this.clientService.readOneByKey(id).orElseThrow( () -> new HttpNotFoundException("Client with Id(" + id + ") doesn't exist"));

        return ResponseEntity.ok(ClientDTO.toDTO(client));
    }

    @PostMapping(path = {"/add"})
    public ResponseEntity<ClientDTO> addClient(@Valid @RequestBody ClientAddForm form){
        Client client = new Client();
        try{
            client = this.clientService.save(form.toBLL());
        }catch (Exception exception){
            throw new HttpPreconditionFailedException(exception.getMessage(), new ArrayList<>());
        }

        return ResponseEntity.ok(ClientDTO.toDTO(client));
    }
}

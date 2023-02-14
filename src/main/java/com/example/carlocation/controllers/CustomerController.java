package com.example.carlocation.controllers;

import com.example.carlocation.exceptions.HttpNotFoundException;
import com.example.carlocation.exceptions.HttpPreconditionFailedException;
import com.example.carlocation.models.dtos.customer.CustomerDTO;
import com.example.carlocation.models.entities.Customer;
import com.example.carlocation.models.forms.CustomerAddForm;
import com.example.carlocation.services.customer.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = {"/client"})
public class CustomerController implements BaseRestController<CustomerDTO, Long>{

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "")
    public ResponseEntity<Collection<CustomerDTO>> readAll(){
        return ResponseEntity.ok(this.customerService.readAll()
                .map(CustomerDTO::toDTO)
                .toList());
    }

    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<CustomerDTO> readOne(@PathVariable Long id){

        Customer customer = this.customerService.readOneByKey(id).orElseThrow( () -> new HttpNotFoundException("Client with Id(" + id + ") doesn't exist"));

        return ResponseEntity.ok(CustomerDTO.toDTO(customer));
    }

    @PostMapping(path = "")
    public ResponseEntity<CustomerDTO> addClient(@Valid @RequestBody CustomerAddForm form){
        Customer customer = form.toBLL();
        try{
            this.customerService.save(customer);
        }catch (Exception exception){
            throw new HttpPreconditionFailedException(exception.getMessage(), new ArrayList<>());
        }

        return ResponseEntity.ok(CustomerDTO.toDTO(customer));
    }

    @PutMapping (path = "/{id:[0-9]+}")
    public ResponseEntity<CustomerDTO> updateOne(@PathVariable Long id, @Valid @RequestBody CustomerAddForm form){
        Customer customer = this.customerService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("Client with Id(" + id + ") doesn't exist"));

        customer.setAddress(form.toBLL().getAddress());
        customer.setFisrtname(form.getFirstname());
        customer.setLastname(form.getLastname());
        customer.setUpdatedAt(LocalDate.now());

        try {
            this.customerService.save(customer);
        } catch (Exception exception){
            throw new HttpPreconditionFailedException("Can't update client", new ArrayList<>());
        }

        return ResponseEntity.ok(CustomerDTO.toDTO(customer));
    }
}

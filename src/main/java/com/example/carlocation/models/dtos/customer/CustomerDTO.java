package com.example.carlocation.models.dtos.customer;

import com.example.carlocation.models.dtos.AddressDTO;
import com.example.carlocation.models.dtos.reservation.ReservationDTO;
import com.example.carlocation.models.entities.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerDTO {

    private Long id;

    private String firstname;

    private String lastname;

    private AddressDTO address;

    public static CustomerDTO toDTO(Customer customer){
        return CustomerDTO.builder()
                .id(customer.getId())
                .firstname(customer.getFisrtname())
                .lastname(customer.getLastname())
                .address(AddressDTO.toDTO(customer.getAddress()))
                .build();
    }
}

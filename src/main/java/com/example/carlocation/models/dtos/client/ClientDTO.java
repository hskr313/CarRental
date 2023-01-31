package com.example.carlocation.models.dtos.client;

import com.example.carlocation.models.dtos.reservation.ReservationDTO;
import com.example.carlocation.models.entities.Address;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDTO {

    private Long id;

    private String firstname;

    private String lastname;


    private AddressDTO address;


    private List<ReservationDTO> reservations;

}

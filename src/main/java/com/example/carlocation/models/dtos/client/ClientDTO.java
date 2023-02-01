package com.example.carlocation.models.dtos.client;

import com.example.carlocation.models.dtos.AddressDTO;
import com.example.carlocation.models.dtos.reservation.ReservationDTO;
import com.example.carlocation.models.entities.Address;
import com.example.carlocation.models.entities.Client;
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

    public static ClientDTO toDTO(Client client){
        return ClientDTO.builder()
                .id(client.getId())
                .firstname(client.getFisrtname())
                .lastname(client.getLastname())
                .address(AddressDTO.toDTO(client.getAddress()))
                .reservations(client.getReservations().stream()
                        .map(ReservationDTO::toDTO)
                        .toList())
                .build();
    }
}

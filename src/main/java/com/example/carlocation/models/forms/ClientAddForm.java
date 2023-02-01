package com.example.carlocation.models.forms;

import com.example.carlocation.models.entities.Client;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientAddForm {

    private String firstname;
    private String lastname;
    private AddressForm address;
    public Client toBLL(){
        return Client.builder()
                .fisrtname(firstname)
                .lastname(lastname)
                .address(address.toBLL())
                .build();
    }

}

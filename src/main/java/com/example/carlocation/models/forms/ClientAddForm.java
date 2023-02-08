package com.example.carlocation.models.forms;

import com.example.carlocation.models.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientAddForm {
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotNull
    private AddressForm address;
    public Client toBLL(){
        return Client.builder()
                .fisrtname(firstname)
                .lastname(lastname)
                .address(address.toBLL())
                .build();
    }

}

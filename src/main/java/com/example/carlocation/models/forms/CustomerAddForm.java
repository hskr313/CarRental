package com.example.carlocation.models.forms;

import com.example.carlocation.models.entities.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerAddForm {
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotNull
    private AddressForm address;
    public Customer toBLL(){
        return Customer.builder()
                .fisrtname(firstname)
                .lastname(lastname)
                .address(address.toBLL())
                .build();
    }

}

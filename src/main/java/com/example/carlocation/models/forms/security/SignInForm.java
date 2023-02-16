package com.example.carlocation.models.forms.security;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInForm {

    private String username;
    private String password;

}

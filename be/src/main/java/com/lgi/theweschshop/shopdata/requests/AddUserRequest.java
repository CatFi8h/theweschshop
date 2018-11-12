package com.lgi.theweschshop.shopdata.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {

    @NotEmpty
    private String email;

    @NotEmpty
    private String name;

    private String surname;

    @NotEmpty
    private String password;
}

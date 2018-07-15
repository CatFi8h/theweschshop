package com.lgi.theweschshop.shopdata.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CartGetListRequestDTO {

    @NotNull(message = "Locale invalid")
    private Integer page = 1;

    @NotNull(message = "Locale invalid")
    private String sort = null;

    @NotNull(message = "Locale invalid")
    private String sessionId;

}

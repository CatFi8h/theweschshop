package com.lgi.theweschshop.shopdata.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartAddDTO {

    private Long id;
    private Long amount;
    private String sessionId;
}

package com.lgi.theweschshop.shopdata.response.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CartElementDTO {

    private String sessionId;

    private Long elementId;

    private Long amount;
}

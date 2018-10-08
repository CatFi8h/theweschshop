package com.lgi.theweschshop.shopdata.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Deprecated
public class ElementListDto {

    private Long id;

    private String name;

    private String type;

    private String size;

    private Integer amount;

    private Double price;


}

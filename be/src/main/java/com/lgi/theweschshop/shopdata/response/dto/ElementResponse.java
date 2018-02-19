package com.lgi.theweschshop.shopdata.response.dto;

import com.lgi.theweschshop.shopdata.model.Element;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElementResponse {

    private Long id;

    private String name;

    private String size;

    private String gender;

    private String type;

    private Integer amount;

    private Double price;


    public ElementResponse( Element element ) {
        this.id = element.getId();
        this.name = element.getName();
        this.size = element.getSize().getSize();
        this.gender = element.getGender();
        this.type = element.getType().getName();
        this.amount = element.getAmount();
        this.price = element.getPrice();
    }
}

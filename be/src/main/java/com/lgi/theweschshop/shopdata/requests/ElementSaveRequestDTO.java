package com.lgi.theweschshop.shopdata.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElementSaveRequestDTO {

    @NotEmpty
    private String type;

    private String name;

    private String size;

    private String description;

    private String color;

    private Long amount;

    private String gender;

    private Double price;
}

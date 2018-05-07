package com.lgi.theweschshop.shopdata.requests;


import lombok.*;
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

    @NonNull
    private Long amount;

    private String gender;

    private Double price;
}

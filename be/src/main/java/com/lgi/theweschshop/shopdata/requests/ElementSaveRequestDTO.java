package com.lgi.theweschshop.shopdata.requests;


import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElementSaveRequestDTO {

    @NotEmpty
    private String type;

    @NonNull
    private String name;

    @NonNull
    private Long sizeId;

    private String description;

    private String color;

    @NonNull
    private Integer amount;

    @NonNull
    private String gender;

    @NonNull
    private Double price;
}

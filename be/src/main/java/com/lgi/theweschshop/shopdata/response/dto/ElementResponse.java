package com.lgi.theweschshop.shopdata.response.dto;

import com.lgi.theweschshop.shopdata.model.Element;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElementResponse {

    private Long id;

    private String name;

    private List<ElementSizeAmountResponseDTO> elementSizeAmountResponseDTO;

    private String gender;

    private TypeResponseDTO type;

    private Double price;

}

package com.lgi.theweschshop.shopdata.controller;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.ElementSizeAmount;
import com.lgi.theweschshop.shopdata.model.SizeEntity;
import com.lgi.theweschshop.shopdata.model.Type;
import com.lgi.theweschshop.shopdata.requests.ElementSaveRequestDTO;
import com.lgi.theweschshop.shopdata.response.ElementResponseList;
import com.lgi.theweschshop.shopdata.response.dto.ElementResponse;
import com.lgi.theweschshop.shopdata.response.dto.ElementSizeAmountResponseDTO;
import com.lgi.theweschshop.shopdata.response.dto.SizeDTO;
import com.lgi.theweschshop.shopdata.response.dto.TypeResponseDTO;
import com.lgi.theweschshop.shopdata.service.ElementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@RequestMapping("api/admin/element")
@RestController
public class AdminElementController {

    private static final Logger l = LoggerFactory.getLogger("");

    @Autowired
    private ElementService elementService;

    @GetMapping(path = "{id}")
    public ElementResponse getElementById(@Param("id") Long id) {
        Optional<ElementResponse> elementById = elementService.getElementById(id);
        return elementById.orElse(new ElementResponse());
    }

    @GetMapping(path = "list")
    public ElementResponseList getListOfElements() {
        var allElements = elementService.getAllElements();
        ElementResponseList responseList = new ElementResponseList();
        ArrayList<ElementResponse> elements = new ArrayList<>();
        responseList.setElements(elements);

        for (Element e : allElements) {
            ElementResponse element = new ElementResponse();
            ArrayList<ElementSizeAmountResponseDTO> elementSizeAmountResponseDTO = new ArrayList<>();


            Set<ElementSizeAmount> elementSizeAmounts = e.getElementSizeAmounts();
            for (ElementSizeAmount elementSizeAmount : elementSizeAmounts) {
                ElementSizeAmountResponseDTO sizeAmountResponseDTO = new ElementSizeAmountResponseDTO();

                sizeAmountResponseDTO.setAmount(elementSizeAmount.getAmount());
                SizeEntity size = elementSizeAmount.getSize();
                sizeAmountResponseDTO.setSize(new SizeDTO(size.getId(), size.getName()));

                elementSizeAmountResponseDTO.add(sizeAmountResponseDTO);
            }

            element.setElementSizeAmountResponseDTO(elementSizeAmountResponseDTO);
            element.setDescription(e.getDescription());
            element.setGender(e.getGender());
            element.setName(e.getName());
            element.setPrice(e.getPrice());
            Type type = e.getType();
            element.setType(new TypeResponseDTO(type.getId(), type.getName()));

            elements.add(element);
        }
        return responseList;
    }

    @PutMapping(path = "save")
    public void saveNewElement(@Valid ElementSaveRequestDTO request) {

        elementService.save(request);

    }

}

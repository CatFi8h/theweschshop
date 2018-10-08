package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.enums.Gender;
import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.ElementSizeAmount;
import com.lgi.theweschshop.shopdata.model.SizeEntity;
import com.lgi.theweschshop.shopdata.model.Type;
import com.lgi.theweschshop.shopdata.repository.ElementRepository;
import com.lgi.theweschshop.shopdata.repository.ElementSizeAmountRepository;
import com.lgi.theweschshop.shopdata.repository.SizeEntityRepository;
import com.lgi.theweschshop.shopdata.repository.TypeRepository;
import com.lgi.theweschshop.shopdata.requests.ElementSaveRequestDTO;
import com.lgi.theweschshop.shopdata.response.ElementResponseList;
import com.lgi.theweschshop.shopdata.response.dto.ElementResponse;
import com.lgi.theweschshop.shopdata.response.dto.ElementSizeAmountResponseDTO;
import com.lgi.theweschshop.shopdata.response.dto.SizeDTO;
import com.lgi.theweschshop.shopdata.response.dto.TypeResponseDTO;
import com.lgi.theweschshop.shopdata.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Service("elementService")
public class ElementServiceImpl implements ElementService {

    @Autowired
    private ElementRepository elementRepository;

    @Autowired
    private TypeRepository typeRepository;
    //sessionId, elementId, amount of elements
    private Map<String, Map<Long, Integer>> cartCache = new HashMap<>();

    @Autowired
    private SizeEntityRepository sizeEntityRepository;

    @Autowired
    private ElementSizeAmountRepository elementSizeAmountRepository;

    @Override
    public List<Element> getAllElements() {
        List<Element> allElements = elementRepository.findAll();
        return allElements;
    }

    @Override
    public List<ElementResponse> getAllElementsResponse() {
        List<Element> allElements = elementRepository.findAll();
        List<ElementResponse> objects = new ArrayList<>();
        for (Element element : allElements) {
            ElementResponse elementResponse = new ElementResponse();
            elementResponse.setGender(element.getGender());
            elementResponse.setId(element.getId());
            elementResponse.setName(element.getName());
            elementResponse.setPrice(element.getPrice());
            TypeResponseDTO type = new TypeResponseDTO();
            Type elementType = element.getType();
            type.setId(elementType.getId());
            type.setName(elementType.getName());
            elementResponse.setType(type);
            Set<ElementSizeAmount> elementSizeAmounts = element.getElementSizeAmounts();
            List<ElementSizeAmountResponseDTO> elementSizeAmountResponseDTOList = new ArrayList<>();
            for (ElementSizeAmount elementSizeAmount : elementSizeAmounts) {
                ElementSizeAmountResponseDTO elementSizeAmountResponseDTO = new ElementSizeAmountResponseDTO();
                elementSizeAmountResponseDTO.setAmount(elementSizeAmount.getAmount());
                SizeDTO size = new SizeDTO();
                size.setId(elementSizeAmount.getSize().getId());
                size.setName(elementSizeAmount.getSize().getName());
                elementSizeAmountResponseDTO.setSize(size);
                elementSizeAmountResponseDTOList.add(elementSizeAmountResponseDTO);
            }
            elementResponse.setElementSizeAmountResponseDTO(elementSizeAmountResponseDTOList);
            objects.add(elementResponse);
        }
        return objects;
    }

    @Override
    public List<Element> getElementsListByType(Type type, Pageable pageable) {
        return (List<Element>) elementRepository.findAllByType(type);
    }

    @Override
    public Element save(ElementSaveRequestDTO elementRequest) {
        String typeStr = elementRequest.getType();
        Integer amount = elementRequest.getAmount();
        Long sizeId = elementRequest.getSizeId();
        String description = elementRequest.getDescription();
        String gender = elementRequest.getGender();
        String name = elementRequest.getName();
        Double price = elementRequest.getPrice();

        Type type = typeRepository.findDistinctByName(typeStr);
        SizeEntity size = sizeEntityRepository.findOne(sizeId);

        Element element = new Element();

        ElementSizeAmount elementSizeAmount = new ElementSizeAmount();
        elementSizeAmount.setElement(element);
        elementSizeAmount.setSize(size);
        elementSizeAmount.setAmount(amount);

        element.setType(type);
        element.setElementSizeAmounts(new HashSet<>(Arrays.asList(elementSizeAmount)));

        element.setDescription(description);
        element.setGender(Gender.valueOf(gender).name());
        element.setName(name);
        element.setIsDeleted(false);

        BigDecimal bigDecimal = new BigDecimal(price);
        element.setPrice(bigDecimal.setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
        element.setCreationDate(new Date(System.currentTimeMillis()));

        return elementRepository.save(element);

    }

    @Override
    public Optional<Element> getElementById(Number elementId) {
        return Optional.ofNullable(elementRepository.findElementById(elementId.longValue()));
    }

    @Override
    @Transactional
    public void delete(Element element) {
        elementRepository.delete(element);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Element elementById = elementRepository.findElementById(id);
        elementById.setIsDeleted(true);
        elementRepository.save(elementById);
    }

    public void addElementToCart(Long elementId, Long sizeId, Integer amount) {

        ElementSizeAmount elementSizeAmount = elementSizeAmountRepository.findByElementAndSize(elementId, sizeId);

        Integer elementAmount = elementSizeAmount.getAmount();

        if (elementAmount < amount) {
            throw new IllegalArgumentException("Not Enough Elements in Storage");
        }

        Element element = elementSizeAmount.getElement();

        String sessionId = "sessionId";
        Map<Long, Integer> sessionCart = cartCache.get(sessionId);
        if (sessionCart == null) {
            sessionCart = new HashMap<>();
        }
        Integer amountOfElementsInCart = sessionCart.get(elementId);
        if (amountOfElementsInCart == null) {
            amountOfElementsInCart = 0;
        }
        amountOfElementsInCart += amount;
        sessionCart.put(element.getId(), amountOfElementsInCart);
        cartCache.put(sessionId, sessionCart);
    }

}

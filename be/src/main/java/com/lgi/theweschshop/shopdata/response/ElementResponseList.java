package com.lgi.theweschshop.shopdata.response;

import com.lgi.theweschshop.shopdata.response.dto.ElementResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ElementResponseList {

    private List<ElementResponse> elements = new ArrayList<>();

    private Long itemsTotal = 0L;

}

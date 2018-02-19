package com.lgi.theweschshop.shopdata.response.dto;

import com.lgi.theweschshop.shopdata.model.SizeEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SizeDTO {

    private Long id;

    private String name;

    public SizeDTO( SizeEntity e ) {

        this.id = e.getId();
        this.name = e.getSize();
    }
}

package com.lgi.theweschshop.shopdata.response.dto;

import com.lgi.theweschshop.shopdata.model.SizeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SizeDTO {

    private Long id;

    private String name;

    public SizeDTO( SizeEntity e ) {

        this.id = e.getId();
        this.name = e.getName();
    }
}

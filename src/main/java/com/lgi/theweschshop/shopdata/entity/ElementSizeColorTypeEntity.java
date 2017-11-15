package com.lgi.theweschshop.shopdata.entity;

import com.lgi.theweschshop.shopdata.enums.Size;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by Igor Yurchenko on 11/13/17.
 */
@Table(schema = "tws_storage", name = "element_size_type_color")
public class ElementSizeColorTypeEntity {

    @Column(name = "element_id")
    private Element element;

    @Column(name = "size_id")
    private Size size;

    @Column(name = "type_id")
    private Type type;

    @Column(name = "color_id")
    private Color color;

    private Long amount;

}

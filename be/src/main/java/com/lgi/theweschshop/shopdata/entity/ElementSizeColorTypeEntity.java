package com.lgi.theweschshop.shopdata.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Igor Yurchenko on 11/13/17.
 */
@Getter
@Setter
@Entity
@Table(schema = "tws_storage", name = "element_size_type_color")
public class ElementSizeColorTypeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Element element;

    @ManyToOne(fetch = FetchType.LAZY)
    private SizeEntity size;

    @ManyToOne(fetch = FetchType.LAZY)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Color color;

    @Column(name = "amount")
    private Long amount;

}

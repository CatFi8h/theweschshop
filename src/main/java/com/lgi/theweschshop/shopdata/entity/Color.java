package com.lgi.theweschshop.shopdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */

@Getter
@Setter
@Entity
@Table(schema = "tws_storage", name = "color")
public class Color {

    @Id
    @GeneratedValue
    private Long cid;

    @Column(name = "color_name")
    private String colorName;

    @OneToMany(mappedBy = "color")
    private List<Element> element;

    private String gradient;


}

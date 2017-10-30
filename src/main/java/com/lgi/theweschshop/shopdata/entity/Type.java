package com.lgi.theweschshop.shopdata.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */

@Getter
@Setter
@Entity
@Table(schema = "tws_storage", name = "e_type")
public class Type {

    @Id
    @GeneratedValue
    private Long tid;

    @Column(name = "type_name")
    private String typeName;

}

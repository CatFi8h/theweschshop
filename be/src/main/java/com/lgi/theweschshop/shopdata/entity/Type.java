package com.lgi.theweschshop.shopdata.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "tws_storage", name = "type_table")
public class Type {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long tid;

    @Column(name = "name")
    private String typeName;

    public Type( String typeName ) {
        this.typeName = typeName;
    }
}

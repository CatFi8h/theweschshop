package com.lgi.theweschshop.shopdata.entity;

import com.lgi.theweschshop.shopdata.enums.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Getter
@Setter
@Entity
@Table(schema = "tws_storage", name = "sizeTable")
public class SizeEntity {

    @Id
    @GeneratedValue
    private Long sid;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Size size;


    public SizeEntity( Size size ) {
        this.size = size;
    }
}

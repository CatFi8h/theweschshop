package com.lgi.theweschshop.shopdata.model;

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
@Table(schema = "tws_storage", name = "size_table")
public class SizeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private Size size;


    public SizeEntity( Size size ) {
        this.size = size;
    }
}

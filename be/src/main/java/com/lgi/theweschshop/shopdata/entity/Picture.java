package com.lgi.theweschshop.shopdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Getter
@Setter
@Entity
@Table(schema = "tws_storage", name = "picture_table")
public class Picture {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long pid;

    @Column(name = "name")
    private String pictureName;

    @Lob
    @Column(name = "picture")
//    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] picture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "id")
    private Element element;

}

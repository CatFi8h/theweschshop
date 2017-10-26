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
@Table(schema = "tws_storage", name = "user")
public class User {

    @Id
    @Column(name = "uid")
    private String id;

    private String password;

    @Column(name = "u_name")
    private String name;

    private String surname;
    @Column(name = "access_type")
    private String accessType;

    private String avatar;

}

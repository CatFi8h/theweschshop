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
    private String id;

    private String password;

    private String name;

    private String surname;

    private String accessType;

    private String avatar;

}

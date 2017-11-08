package com.lgi.theweschshop.shopdata.entity;

import com.lgi.theweschshop.shopdata.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "tws_storage", name = "user")
public class User {

    @Id
    @Email
    @NonNull
    @Column(name = "uid")
    private String id;

    private String password;

    @Column(name = "u_name")
    private String name;

    private String surname;
    @Column(name = "access_type")
    private String accessType;

    private String avatar;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public User( String id, String name, String password ) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public User( String id,  String name, String surname, String password ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accessType='" + accessType + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}

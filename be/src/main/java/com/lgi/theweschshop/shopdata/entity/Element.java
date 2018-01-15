package com.lgi.theweschshop.shopdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lgi.theweschshop.shopdata.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */

@Getter
@Setter
@Entity
@Table(schema = "tws_storage", name = "element_table")
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "element", fetch = FetchType.EAGER)
    private List<Comment> comment;

    @Column(name = "gender")
    private String gender;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "element", fetch = FetchType.LAZY)
    private Set<Picture> picture;

    @Column(name = "size")
    private String elementSize;

    @Column(name = "color")
    private String color;

    @Column(name = "amount")
    private Long amount;

    public Element( String name, String description ) {
        this.name = name;
        this.description = description;
    }

}

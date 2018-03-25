package com.lgi.theweschshop.shopdata.model;

import com.lgi.theweschshop.shopdata.enums.Gender;
import com.lgi.theweschshop.shopdata.enums.Size;
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

    @OneToMany(mappedBy = "element", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Column(name = "gender")
    private String gender;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "type")
    private Type type;

    @OneToMany(mappedBy = "element", fetch = FetchType.EAGER)
    private List<Picture> pictures;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "size")
    private SizeEntity size;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "price", scale = 0, columnDefinition="numeric")
    private Double price;

    @Column(name = "components")
    private String components;

}

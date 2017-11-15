package com.lgi.theweschshop.shopdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lgi.theweschshop.shopdata.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */

@Getter
@Setter
@Entity
@Table(schema = "tws_storage", name = "elementTable")
public class Element {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String comment;

    private Gender gender;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "element_type",
            joinColumns = {@JoinColumn(name = "element_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id", referencedColumnName = "tid")}
    )
    private Set<Type> type;

    @OneToMany(mappedBy = "element", fetch = FetchType.LAZY)
    private Set<Picture> picture;


    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "element_size",
            joinColumns = {@JoinColumn(name = "element_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "size_id", referencedColumnName = "sid")}
    )
    private Set<SizeEntity> sizeEntities;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "element_color",
            joinColumns = {@JoinColumn(name = "element_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "color_id", referencedColumnName = "cid")}
    )
    private Set<Color> color;

    public Element( String name, String description, Type type, Color white, SizeEntity sizeEntity, Gender male  ) {
        this.name = name;
        this.description = description;
        this.comment = "";
        this.gender = male;
        this.creationDate = new Date();
        this.type.add( type );
        this.picture = null;
        this.sizeEntities.add( sizeEntity );
        this.color.add( white );
    }

    public Element( String name, String description ) {
        this.name = name;
        this.description = description;
    }

//    public Element( String elementName, String description, Type type, Color white, SizeEntity sizeEntity, Gender male ) {
//        this.name = elementName;
//        this.description = description;
//    }
}

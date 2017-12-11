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
@Table(schema = "tws_storage", name = "element_table")
public class Element {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "comment")
    private String comment;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Type type;

    @OneToMany(mappedBy = "element", fetch = FetchType.LAZY)
    private Set<Picture> picture;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
//    @JoinTable(name = "element_size_type_color", joinColumns = @JoinColumn(name = "element_id"),
//            inverseJoinColumns = @JoinColumn(name = "size_id"))
    private SizeEntity sizeEntities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Color color;

    public Element( String name, String description ) {
        this.name = name;
        this.description = description;
    }

}



//    @ManyToOne
//    @JsonIgnore
//    private Type type;
//
//    @OneToMany(mappedBy = "element", fetch = FetchType.LAZY)
//    private Set<Picture> picture;
//
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonIgnore
////    @JoinTable(
////            name = "element_size",
////            joinColumns = {@JoinColumn(name = "element_id", referencedColumnName = "id")},
////            inverseJoinColumns = {@JoinColumn(name = "size_id", referencedColumnName = "sid")}
////    )
//    private SizeEntity sizeEntities;
//
//    @ManyToOne
//    @JsonIgnore
////    @JoinTable(
////            name = "element_color",
////            joinColumns = {@JoinColumn(name = "element_id", referencedColumnName = "id")},
////            inverseJoinColumns = {@JoinColumn(name = "color_id", referencedColumnName = "cid")}
////    )
//    private Color color;
//
////    public Element( String name, String description, Type type, Color white, SizeEntity sizeEntity, Gender male  ) {
////        this.name = name;
////        this.description = description;
////        this.comment = "";
////        this.gender = male;
////        this.creationDate = new Date();
////        if ( this.type == null ) {
////            this.type = new HashSet<>();
////        }
////        this.type.add( type );
////        if ( this.picture == null ) {
////            this.picture = new HashSet<>();
////        }
////        this.picture = null;
////        if ( this.sizeEntities == null ) {
////            this.sizeEntities = new HashSet<>();
////        }
////        this.sizeEntities.add( sizeEntity );
////        if ( this.color == null ) {
////            this.color = new HashSet<>();
////        }
////        this.color.add( white );
////    }
package com.lgi.theweschshop.shopdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lgi.theweschshop.shopdata.domain.Size;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */

@Getter
@Setter
@Entity
@Table(schema = "tws_storage", name = "element")
public class Element {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Size size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "cid")
    private List<Color> color;

    private String description;

    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "tid")
    private List<Type> type;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    private Integer availableAmount;

    @OneToMany(mappedBy = "element")
    private Picture pictureId;

}

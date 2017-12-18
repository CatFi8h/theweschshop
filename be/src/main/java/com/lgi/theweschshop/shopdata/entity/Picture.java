package com.lgi.theweschshop.shopdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "tws_storage", name = "picture_table")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String pictureName;

    @Lob
    @Column(name = "picture")
    private byte[] picture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(schema = "tws_storage", name = "element_table", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "picture_id"))
    private Element element;

}

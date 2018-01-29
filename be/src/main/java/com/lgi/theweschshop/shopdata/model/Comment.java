package com.lgi.theweschshop.shopdata.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private Element element;
}

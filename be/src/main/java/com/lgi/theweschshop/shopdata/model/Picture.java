package com.lgi.theweschshop.shopdata.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;

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

    @Column(name = "picture")
    private byte[] picture;

    @ManyToOne(fetch = FetchType.LAZY)
    private Element element;

    public String getEncodedString() {
        return Base64.encodeBase64URLSafeString( this.picture );
    }
}

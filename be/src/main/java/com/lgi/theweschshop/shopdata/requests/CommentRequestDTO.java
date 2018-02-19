package com.lgi.theweschshop.shopdata.requests;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentRequestDTO {

    private Long id;

    private String email;

    private String name;

    private String comment;


}

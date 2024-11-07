package com.yassine.product_composite.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Recommendation {
    private long id;
    private long productID;
    private String author;
    private String subject;
    private String content;
}
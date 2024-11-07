package com.yassine.product_composite.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {
    private long id;
    private long productId;
    private String author;
    private String content;
    private float rate;
}

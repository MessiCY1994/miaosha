package com.messiyang.miaosha.model;


import lombok.Data;

@Data
public class Goods {
    private Long id;

    private String goodsTitle;

    private String goodsImg;

    private String goodsName;

    private String goodsDetail;

    private String goodsStock;

    private Double goodsPrice;


}
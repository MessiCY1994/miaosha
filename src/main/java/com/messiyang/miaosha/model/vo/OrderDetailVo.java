package com.messiyang.miaosha.model.vo;


import com.messiyang.miaosha.model.OrderInfo;
import lombok.Data;

@Data
public class OrderDetailVo {
    private GoodsVo goods;
    private OrderInfo order;
}

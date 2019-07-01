package com.messiyang.miaosha.dao;

import com.messiyang.miaosha.model.OrderInfo;

public interface OrderInfoMapper {
    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);
}
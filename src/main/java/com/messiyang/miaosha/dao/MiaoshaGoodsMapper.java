package com.messiyang.miaosha.dao;

import com.messiyang.miaosha.model.MiaoshaGoods;
import org.springframework.stereotype.Repository;

@Repository
public interface MiaoshaGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MiaoshaGoods record);

    int insertSelective(MiaoshaGoods record);

    MiaoshaGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MiaoshaGoods record);

    int updateByPrimaryKey(MiaoshaGoods record);

    int reduceStock(MiaoshaGoods g);

     int resetStock(MiaoshaGoods g);
}
package com.messiyang.miaosha.dao;

import com.messiyang.miaosha.model.MiaoshaOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface MiaoshaOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MiaoshaOrder record);

    int insertSelective(MiaoshaOrder record);

    MiaoshaOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MiaoshaOrder record);

    int updateByPrimaryKey(MiaoshaOrder record);
}
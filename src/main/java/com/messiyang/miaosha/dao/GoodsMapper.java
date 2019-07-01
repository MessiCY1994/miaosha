package com.messiyang.miaosha.dao;

import com.messiyang.miaosha.model.Goods;
import com.messiyang.miaosha.model.vo.GoodsVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    GoodsVo getGoodsVoByGoodsId(Long goodsId);

    List<GoodsVo> listGoodsVo();


}
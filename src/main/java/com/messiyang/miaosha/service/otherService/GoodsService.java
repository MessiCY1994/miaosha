package com.messiyang.miaosha.service.otherService;


import com.messiyang.miaosha.dao.GoodsMapper;
import com.messiyang.miaosha.dao.MiaoshaGoodsMapper;
import com.messiyang.miaosha.model.MiaoshaGoods;
import com.messiyang.miaosha.model.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    MiaoshaGoodsMapper miaoshaGoodsMapper;

    public List<GoodsVo> listGoodsVo() {
        return goodsMapper.listGoodsVo();
    }

    public GoodsVo getGoodsVoByGoodsId(long goodsId) {
        return goodsMapper.getGoodsVoByGoodsId(goodsId);
    }

    public boolean reduceStock(GoodsVo goods) {
        MiaoshaGoods g = new MiaoshaGoods();
        g.setGoodsId(goods.getId());
        int ret = miaoshaGoodsMapper.reduceStock(g);
        return ret > 0;
    }

    public void resetStock(List<GoodsVo> goodsList) {
        for (GoodsVo goods : goodsList) {
            MiaoshaGoods g = new MiaoshaGoods();
            g.setGoodsId(goods.getId());
            g.setStockCount(goods.getStockCount().toString());
            miaoshaGoodsMapper.resetStock(g);
        }
    }


}

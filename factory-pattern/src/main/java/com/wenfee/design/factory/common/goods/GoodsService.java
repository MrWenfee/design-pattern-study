package com.wenfee.design.factory.common.goods;

import com.alibaba.fastjson.JSON;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 模拟实物商品服务
 */
public class GoodsService {

    public Boolean deliverGoods(DeliverRequest req) {
        System.out.println("模拟发货实物商品一个：" + JSON.toJSONString(req));
        return true;
    }
}

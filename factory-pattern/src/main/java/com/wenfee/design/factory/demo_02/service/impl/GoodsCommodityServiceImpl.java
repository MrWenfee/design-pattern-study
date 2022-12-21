package com.wenfee.design.factory.demo_02.service.impl;

import com.alibaba.fastjson.JSON;
import com.wenfee.design.factory.common.goods.DeliverRequest;
import com.wenfee.design.factory.common.goods.GoodsService;
import com.wenfee.design.factory.demo_02.service.ICommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 实物商品服务
 */
public class GoodsCommodityServiceImpl implements ICommodityService {

    private Logger logger = LoggerFactory.getLogger(GoodsCommodityServiceImpl.class);

    private GoodsService goodsService = new GoodsService();

    @Override
    public void sendCommodity(String userId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        DeliverRequest deliverReq = new DeliverRequest();
        deliverReq.setUserName(queryUserName(userId));
        deliverReq.setUserPhone(queryUserPhoneNumber(userId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));

        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", userId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", isSuccess);

        if (!isSuccess) {
            throw new RuntimeException("实物商品发放失败");
        }
    }

    private String queryUserName(String userId) {
        return "Wenfee";
    }

    private String queryUserPhoneNumber(String userId) {
        return "12345678909";
    }
}

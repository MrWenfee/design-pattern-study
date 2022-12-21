package com.wenfee.design.factory.demo_02.service.impl;

import com.alibaba.fastjson.JSON;
import com.wenfee.design.factory.common.coupon.CouponResult;
import com.wenfee.design.factory.common.coupon.CouponService;
import com.wenfee.design.factory.demo_02.service.ICommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 优惠卷奖品服务
 */
public class CouponCommodityServiceImpl implements ICommodityService {

    private Logger logger = LoggerFactory.getLogger(CouponCommodityServiceImpl.class);

    /**
     * 模拟注入
     */
    private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String userId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(userId, commodityId, bizId);
        logger.info("请求参数[优惠券] => userId：{} commodityId：{} bizId：{} extMap：{}", userId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!Objects.equals("0000", couponResult.getCode())) {
            throw new RuntimeException(couponResult.getInfo());
        }
    }
}

package com.wenfee.design.factory.demo_01;

import com.alibaba.fastjson.JSON;
import com.wenfee.design.factory.common.card.IQiYiCard;
import com.wenfee.design.factory.common.card.IQiYiCardService;
import com.wenfee.design.factory.common.coupon.CouponInfo;
import com.wenfee.design.factory.common.coupon.CouponResult;
import com.wenfee.design.factory.common.coupon.CouponService;
import com.wenfee.design.factory.common.goods.DeliverRequest;
import com.wenfee.design.factory.common.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 模拟发奖服务
 */
public class PrizeController {

    private Logger logger = LoggerFactory.getLogger(PrizeController.class);

    /**
     * 模拟发送奖品
     *
     * @param request
     * @return
     */
    public AwardResponse awardToUser(AwardRequest request) {
        AwardResponse response = null;
        String jsonRequestString = JSON.toJSONString(request);

        try {
            logger.info("模拟奖品发放开始 {}", jsonRequestString);
            // 奖品类型: [1-优惠券; 2-实物商品; 3第三方兑换卡(爱奇艺)]
            if (Objects.equals(request.getAwardType(), 1)) {
                logger.info("模拟奖品发放类型为: 优惠卷");
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(new CouponInfo(request.getBizId(), request.getUserId(), request.getAwardNumber()));
                if (Objects.equals("0000", couponResult.getCode())) {
                    response = new AwardResponse("0000", "发放成功");
                } else {
                    response = new AwardResponse("0001", "发放成功");
                }

            } else if (Objects.equals(request.getAwardType(), 2)) {
                logger.info("模拟奖品发放类型为: 实物商品");
                GoodsService goodsService = new GoodsService();
                DeliverRequest deliverRequest = new DeliverRequest();
                deliverRequest.setUserName(queryUserName(request.getUserId()));
                deliverRequest.setUserPhone(queryUserPhoneNumber(request.getUserId()));
                deliverRequest.setSku(request.getAwardNumber());
                deliverRequest.setOrderId(request.getBizId());
                deliverRequest.setConsigneeUserName(request.getExtMap().get("consigneeUserName"));
                deliverRequest.setConsigneeUserPhone(request.getExtMap().get("consigneeUserPhone"));
                deliverRequest.setConsigneeUserAddress(request.getExtMap().get("consigneeUserAddress"));

                Boolean isSuccess = goodsService.deliverGoods(deliverRequest);

                if (isSuccess) {
                    response = new AwardResponse("0000", "实物商品发放成功");
                } else {
                    response = new AwardResponse("0001", "实物商品发放失败");
                }

            } else if (Objects.equals(request.getAwardType(), 3)) {
                logger.info("模拟奖品发放类型为: 第三方兑换卡(爱奇艺)");
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                IQiYiCard iQiYiCard = new IQiYiCard(queryUserPhoneNumber(request.getUserId()), request.getAwardNumber());
                iQiYiCardService.grantToken(iQiYiCard);
                response = new AwardResponse("0000", "发放成功");

            } else {
                logger.error("模拟奖品发放失败，不支持的奖品类型: {}", request.getAwardType());
            }
            logger.info("奖品发放完成，接收奖品用户ID: {}", request.getUserId());
        } catch (Exception e) {
            logger.error("奖品发放失败 {}. request: {}", request.getUserId(), jsonRequestString, e);
            response = new AwardResponse("0001", e.getMessage());
        }

        return response;
    }

    /**
     * 模拟根据用户id，查询用户名称
     *
     * @param userId
     * @return 用户名称
     */
    private String queryUserName(String userId) {
        return "Wenfee";
    }

    /**
     * /**
     * 模拟根据用户id，查询用户手机号码
     *
     * @param userId
     * @return 用户手机号码
     */
    private String queryUserPhoneNumber(String userId) {
        return "15200101232";
    }
}


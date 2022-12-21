package com.wenfee.design.factory.common.coupon;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 模拟优惠券服务
 */
public class CouponService {

    public CouponResult sendCoupon(String uId, String couponNumber, String uuid) {
        System.out.println("模拟发放优惠券一张：" + uId + "," + couponNumber + "," + uuid);
        return new CouponResult("0000", "发放成功");
    }

    public CouponResult sendCoupon(CouponInfo couponInfo) {
        System.out.println("模拟发放优惠券一张：" + couponInfo.getUserId() + "," + couponInfo.getCouponNumber() + "," + couponInfo.getUuid());
        return new CouponResult("0000", "发放成功");
    }
}

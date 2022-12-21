package com.wenfee.design.factory.common.coupon;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 优惠价奖品
 */
public class CouponInfo {

    /**
     * uuid
     */
    private String uuid;

    /**
     * 用户id
     */
    private String UserId;

    /**
     * 优惠价号码
     */
    private String couponNumber;

    public CouponInfo(String uuid, String UserId, String couponNumber) {
        this.uuid = uuid;
        this.UserId = UserId;
        this.couponNumber = couponNumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }


    public String getCouponNumber() {
        return couponNumber;
    }

    public void setCouponNumber(String couponNumber) {
        this.couponNumber = couponNumber;
    }
}

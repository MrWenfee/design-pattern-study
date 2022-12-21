package com.wenfee.design.factory.common.coupon;

/**
 * @author Wenfee
 * @date 2022/12/22
 */
public class CouponResult {

    /**
     * 编码
     */
    private String code;

    /**
     * 描述
     */
    private String info;

    public CouponResult(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

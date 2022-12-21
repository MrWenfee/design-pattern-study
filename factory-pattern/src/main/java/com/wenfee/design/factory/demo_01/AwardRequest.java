package com.wenfee.design.factory.demo_01;

import java.util.Map;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 奖品的入参对象
 */
public class AwardRequest {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 奖品类型(可以用枚举定义); 1- 优惠券; 2- 实物商品; 3- 第三方兑换卡(爱奇艺);
     */
    private Integer awardType;

    /**
     * 奖品编号；sku、couponNumber、cardId
     */
    private String awardNumber;

    /**
     * 业务ID，防重复
     */
    private String bizId;

    /**
     * 扩展信息
     */
    private Map<String, String> extMap;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Map<String, String> getExtMap() {
        return extMap;
    }

    public void setExtMap(Map<String, String> extMap) {
        this.extMap = extMap;
    }
}

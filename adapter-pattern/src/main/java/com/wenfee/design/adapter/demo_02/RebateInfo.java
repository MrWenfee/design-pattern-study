package com.wenfee.design.adapter.demo_02;

import java.util.Date;

/**
 * @author Wenfee
 * @date 2022/12/24
 */
public class RebateInfo {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 业务ID
     */
    private String bizId;

    /**
     * 业务时间
     */
    private Date bizTime;

    /**
     * 业务描述
     */
    private String desc;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Date getBizTime() {
        return bizTime;
    }

    public void setBizTime(Date bizTime) {
        this.bizTime = bizTime;
    }

    public void setBizTime(String bizTime) {
        this.bizTime = new Date();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

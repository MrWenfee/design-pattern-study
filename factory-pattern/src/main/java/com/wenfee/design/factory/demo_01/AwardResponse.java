package com.wenfee.design.factory.demo_01;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 奖品出参对象
 */
public class AwardResponse {

    /**
     * 编码: 0000-响应成功；
     */
    private String code;

    /**
     * 描述
     */
    private String info;

    public AwardResponse(String code, String info) {
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

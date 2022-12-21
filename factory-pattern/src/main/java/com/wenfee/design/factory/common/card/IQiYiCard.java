package com.wenfee.design.factory.common.card;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 爱奇艺奖品
 */
public class IQiYiCard {

    /**
     * 爱奇艺绑定手机号码
     */
    private String bindMobileNumber;

    /**
     * 爱奇艺会员卡号
     */
    private String cardId;

    public IQiYiCard(String bindMobileNumber, String cardId) {
        this.bindMobileNumber = bindMobileNumber;
        this.cardId = cardId;
    }

    public String getBindMobileNumber() {
        return bindMobileNumber;
    }

    public void setBindMobileNumber(String bindMobileNumber) {
        this.bindMobileNumber = bindMobileNumber;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}

package com.wenfee.design.factory.common.card;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 模拟爱奇艺奖品会员服务
 */
public class IQiYiCardService {

    public void grantToken(String bindMobileNumber, String cardId) {
        System.out.println("模拟发放爱奇艺会员卡一张：" + bindMobileNumber + "，" + cardId);
    }

    public void grantToken(IQiYiCard iQiYiCard) {
        System.out.println("模拟发放爱奇艺会员卡一张：" + iQiYiCard.getBindMobileNumber() + "，" + iQiYiCard.getCardId());
    }
}

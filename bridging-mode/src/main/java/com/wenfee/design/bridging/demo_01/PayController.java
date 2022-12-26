package com.wenfee.design.bridging.demo_01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author Wenfee
 * @date 2022/12/26
 */
public class PayController {

    private Logger logger = LoggerFactory.getLogger(PayController.class);

    /**
     * @param uId         {@code uId} 用户id
     * @param tradeId     {@code tradeId} 交易编号
     * @param amount      {@code amount} 支付金额
     * @param channelType {@code channelType} 支付渠道类型: [ 1-微信; 2-支付宝; ]
     * @param payType     {@code payType} 支付类型: [ 1-密码支付; 2-人脸支付; 3-指纹支付; ]
     * @return
     */
    public boolean doPay(String uId, String tradeId, BigDecimal amount, Integer channelType, Integer payType) {
        // 微信支付
        if (1 == channelType) {
            logger.info("模拟微信渠道支付划账开始. uId: {}; tradeId: {}; amount: {}", uId, tradeId, amount);
            if (1 == payType) {
                logger.info("密码支付, 风控校验环境安全");
            } else if (2 == payType) {
                logger.info("人脸支付, 风控校验脸部识别");
            } else if (3 == payType) {
                logger.info("指纹支付, 风控校验指纹信息");
            }
        }
        // 支付宝支付
        else if (2 == channelType) {
            logger.info("模拟支付宝渠道支付划账开始. uId: {}; tradeId: {}; amount: {}", uId, tradeId, amount);
            if (1 == payType) {
                logger.info("密码支付, 风控校验环境安全");
            } else if (2 == payType) {
                logger.info("人脸支付, 风控校验脸部识别");
            } else if (3 == payType) {
                logger.info("指纹支付, 风控校验指纹信息");
            }
        }
        return true;
    }

}

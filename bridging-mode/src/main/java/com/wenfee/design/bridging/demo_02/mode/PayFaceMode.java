package com.wenfee.design.bridging.demo_02.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Wenfee
 * @date 2022/12/26
 * <p>
 * 人脸支付
 */
public class PayFaceMode implements IPayMode {

    protected Logger logger = LoggerFactory.getLogger(PayCypher.class);

    @Override
    public boolean security(String uId) {
        logger.info("人脸支付, 风控校验脸部识别");
        return true;
    }
}

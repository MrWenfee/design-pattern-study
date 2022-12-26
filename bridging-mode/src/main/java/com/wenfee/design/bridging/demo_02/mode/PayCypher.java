package com.wenfee.design.bridging.demo_02.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Wenfee
 * @date 2022/12/26
 * <p>
 * 密码支付
 */
public class PayCypher implements IPayMode {

    protected Logger logger = LoggerFactory.getLogger(PayCypher.class);

    @Override
    public boolean security(String uId) {
        logger.info("密码支付, 风控校验环境安全");
        return true;
    }

}

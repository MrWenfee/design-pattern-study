package com.wenfee.design.adapter.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Wenfee
 * @date 2022/12/24
 */
public class POPOrderService {

    private Logger logger = LoggerFactory.getLogger(POPOrderService.class);

    public boolean isFirstOrder(String uid) {
        logger.info("POP商家，查询用户的订单是否为首单：{}", uid);
        return true;
    }
}

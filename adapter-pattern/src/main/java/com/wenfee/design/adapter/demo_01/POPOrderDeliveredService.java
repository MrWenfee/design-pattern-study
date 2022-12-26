package com.wenfee.design.adapter.demo_01;

import com.alibaba.fastjson.JSON;
import com.wenfee.design.adapter.common.mq.POPOrderDelivered;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Wenfee
 * @date 2022/12/24
 */
public class POPOrderDeliveredService {

    private Logger logger = LoggerFactory.getLogger(POPOrderDeliveredService.class);

    public void onMessage(String message) {

        POPOrderDelivered mq = JSON.parseObject(message, POPOrderDelivered.class);

        mq.getUid();
        mq.getOrderId();
        mq.getOrderTime();

        logger.info("用户标识: {}; 订单id: {}; 订单创建时间: {}", mq.getUid(), mq.getOrderId(), mq.getOrderTime());
    }
}

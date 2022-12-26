package com.wenfee.design.adapter.demo_01;

import com.alibaba.fastjson.JSON;
import com.wenfee.design.adapter.common.mq.OrderMq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Wenfee
 * @date 2022/12/24
 */
public class OrderMqService {

    private Logger logger = LoggerFactory.getLogger(OrderMqService.class);

    public void onMessage(String message) {

        OrderMq mq = JSON.parseObject(message, OrderMq.class);
        mq.getUid();
        mq.getOrderId();
        mq.getCreateOrderTime();

        logger.info("用户标识: {}; 订单id: {}; 订单创建时间: {}", mq.getUid(), mq.getOrderId(), mq.getCreateOrderTime());
    }
}

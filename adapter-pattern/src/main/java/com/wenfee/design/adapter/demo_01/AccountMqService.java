package com.wenfee.design.adapter.demo_01;

import com.alibaba.fastjson.JSON;
import com.wenfee.design.adapter.common.mq.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Wenfee
 * @date 2022/12/24
 */
public class AccountMqService {

    private Logger logger = LoggerFactory.getLogger(AccountMqService.class);

    public void onMessage(String message) {
        Account mq = JSON.parseObject(message, Account.class);

        mq.getNumber();
        mq.getAccountDate();

        logger.info("开户编号: {}; 开户时间: {}", mq.getNumber(), mq.getAccountDate());
    }
}

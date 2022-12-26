package com.wenfee.design.adapter.demo_02.impl;

import com.wenfee.design.adapter.common.service.OrderService;
import com.wenfee.design.adapter.demo_02.OrderAdapterService;

/**
 * @author Wenfee
 * @date 2022/12/24
 */
public class InsideOrderServiceImpl implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    @Override
    public boolean isFirst(String uid) {
        return orderService.queryUserOrderCount(uid) <= 1;
    }
}

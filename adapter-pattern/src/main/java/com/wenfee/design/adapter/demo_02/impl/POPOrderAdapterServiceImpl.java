package com.wenfee.design.adapter.demo_02.impl;

import com.wenfee.design.adapter.common.service.POPOrderService;
import com.wenfee.design.adapter.demo_02.OrderAdapterService;

/**
 * @author Wenfee
 * @date 2022/12/24
 */
public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    private POPOrderService popOrderService = new POPOrderService();

    @Override
    public boolean isFirst(String uid) {
        return popOrderService.isFirstOrder(uid);
    }
}

package com.wenfee.design.factory.demo_02.service.impl;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.wenfee.design.factory.common.card.IQiYiCardService;
import com.wenfee.design.factory.demo_02.service.ICommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 第三方兑换卡(爱奇艺) 服务
 */
public class CardCommodityServiceImpl implements ICommodityService {

    private Logger logger = LoggerFactory.getLogger(CardCommodityServiceImpl.class);

    /**
     * 模拟注入
     */
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String userId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        String mobile = queryUserMobile(userId);
        iQiYiCardService.grantToken(mobile, bizId);
        logger.info("请求参数[爱奇艺兑换卡] => userId：{} commodityId：{} bizId：{} extMap：{}", userId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserMobile(String userId) {
        return "12345678901";
    }
}

package com.wenfee.design.factory.demo_02.service;

import java.util.Map;

/**
 * @author Wenfee
 * @date 2022/12/22
 */
public interface ICommodityService {

    /**
     * 发送奖品
     *
     * @param userId
     * @param commodityId
     * @param bizId
     * @param extMap
     * @throws Exception
     */
    void sendCommodity(String userId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}

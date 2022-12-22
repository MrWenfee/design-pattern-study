package com.wenfee.design.test;

import com.wenfee.design.demo_01.ICacheService;
import com.wenfee.design.demo_01.impl.CacheServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 单元测试- 抽象工厂模式
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    /**
     * 后期增加集群类型，维护较困难；
     * 通过RedisType字段的值，在service上判断来实现具体调用 EGM集群 还是 IIR集群；
     */
    @Test
    public void test_abstract_factory_demo_01() {
        // 使用的是 demo_01 包下的service; common 包下也存在该名字的service（不要导错类类）；
        ICacheService cacheService = new CacheServiceImpl();
        Integer redisType = 2;
        String cacheKey = "user_name_01";
        cacheService.set(cacheKey, "Wenfee", redisType);
        String cacheValue = cacheService.get(cacheKey, redisType);
        logger.info("获取缓存 key: {}; value: {}", cacheKey, cacheValue);
    }
}

package com.wenfee.design.test;

import com.wenfee.design.demo_01.ICacheService;
import com.wenfee.design.demo_01.impl.CacheServiceImpl;
import com.wenfee.design.demo_02.factory.JDKProxy;
import com.wenfee.design.demo_02.factory.impl.EGMCacheAdapter;
import com.wenfee.design.demo_02.factory.impl.IIRCacheAdapter;
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

    /**
     * 通过动态代理方式
     */
    @Test
    public void test_abstract_factory_demo_02() {
        // 父类引用
        com.wenfee.design.demo_02.service.ICacheService proxy_EGM = new JDKProxy().getProxy(com.wenfee.design.demo_02.service.impl.CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01", "Wenfee");
        String val01 = proxy_EGM.get("user_name_01");
        logger.info("动态代理， EGM 测试结果: {}", val01);

        System.out.println();

        com.wenfee.design.demo_02.service.ICacheService proxy_IIR = new JDKProxy().getProxy(com.wenfee.design.demo_02.service.impl.CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_02", "Wenfee");
        String val02 = proxy_IIR.get("user_name_02");
        logger.info("动态代理， EGM 测试结果: {}", val02);
    }
}

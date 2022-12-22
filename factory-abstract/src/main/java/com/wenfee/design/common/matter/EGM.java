package com.wenfee.design.common.matter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 模拟集群EGM
 */
public class EGM {

    private Logger logger = LoggerFactory.getLogger(EGM.class);

    /**
     * 模拟redis缓存数据
     * synchronized 修复put 方法，线程安全
     */
    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String gain(String key) {
        logger.info("EGM 获取数据 key: {}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        logger.info("EGM 写入数据 key: {}; val: {}", key, value);
        dataMap.put(key, value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        logger.info("EGM 写入数据 key: {}; val: {}; timeout: {}; timeUnit: {}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void delete(String key) {
        logger.info("EGM 删除数据 key: {}", key);
        dataMap.remove(key);
    }
}

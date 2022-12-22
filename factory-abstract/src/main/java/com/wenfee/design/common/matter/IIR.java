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
 * 模拟集群IIR
 */
public class IIR {

    private Logger logger = LoggerFactory.getLogger(IIR.class);

    /**
     * 模拟redis缓存数据
     * synchronized 修复put 方法，线程安全
     */
    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key) {
        logger.info("IIR 获取数据 key: {}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        logger.info("IIR 写入数据 key: {}; val: {}", key, value);
        dataMap.put(key, value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        logger.info("IIR 写入数据 key: {}; val: {}; timeout: {}; timeUnit: {}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void del(String key) {
        logger.info("IIR 删除数据 key: {}", key);
        dataMap.remove(key);
    }

}

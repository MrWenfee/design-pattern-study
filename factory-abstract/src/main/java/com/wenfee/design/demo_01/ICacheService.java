package com.wenfee.design.demo_01;

import java.util.concurrent.TimeUnit;

/**
 * @author Wenfee
 * @date 2022/12/22
 */
public interface ICacheService {

    /**
     * @param key       {@code key} 缓存 key
     * @param redisType {@code redisType} 集群类型：1-EGM; 2-IIR;
     * @return
     */
    String get(final String key, int redisType);

    /**
     * @param key       {@code key} 缓存 key
     * @param value     {@code value} 缓存 value
     * @param redisType {@code redisType} 集群类型：1-EGM; 2-IIR;
     */
    void set(String key, String value, int redisType);

    /**
     * @param key       {@code key} 缓存 key
     * @param value     {@code value} 缓存 value
     * @param timeout   {@code timeout} 缓存过期时间
     * @param timeUnit  {@code timeUnit} 缓存过期时间单位
     * @param redisType redisType {@code redisType} 集群类型：1-EGM; 2-IIR;
     */
    void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType);

    /**
     * @param key       {@code key} 缓存 key
     * @param redisType {@code redisType} 集群类型：1-EGM; 2-IIR;
     */
    void del(String key, int redisType);
}

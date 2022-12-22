package com.wenfee.design.demo_02.service.impl;

import com.wenfee.design.common.RedisUtils;
import com.wenfee.design.demo_02.service.ICacheService;

import java.util.concurrent.TimeUnit;

/**
 * @author Wenfee
 * @date 2022/12/22
 */
public class CacheServiceImpl implements ICacheService {

    private RedisUtils redisUtils = new RedisUtils();

    @Override
    public String get(String key) {
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    @Override
    public void setStr(String key, String value) {
        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtils.set(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        redisUtils.del(key);
    }
}

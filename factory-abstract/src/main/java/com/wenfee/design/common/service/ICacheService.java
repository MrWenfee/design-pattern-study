package com.wenfee.design.common.service;

import java.util.concurrent.TimeUnit;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 缓存服务
 */
public interface ICacheService {

    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}

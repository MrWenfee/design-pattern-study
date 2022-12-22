package com.wenfee.design.demo_02.factory;

import java.util.concurrent.TimeUnit;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 缓存适配器类
 * 所有集群的提供⽅，能在统⼀的⽅法名称下进⾏操作
 */
public interface ICacheAdapter {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}

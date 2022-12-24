package com.wenfee.design.singleton;

import cn.hutool.core.util.ObjectUtil;

import java.util.Objects;

/**
 * @author Wenfee
 * @date 2022/12/24
 * <p>
 * 单例模式- 饿汉模式
 * 线程安全：安全
 * 双重锁校验
 */
public class Singleton_05 {

    private static Singleton_05 instance;

    private Singleton_05() {
    }

    /**
     * 双重锁校验
     *
     * @return
     */
    public static Singleton_05 getInstance() {
        if (ObjectUtil.isNotNull(instance)) {
            return instance;
        }

        synchronized (Singleton_05.class) {
            if (Objects.isNull(instance)) {
                instance = new Singleton_05();
            }
        }
        return instance;
    }
}

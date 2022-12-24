package com.wenfee.design.singleton;

import java.util.Objects;

/**
 * @author Wenfee
 * @date 2022/12/24
 *
 * 单例模式- 懒汉模式
 * 线程安全: 安全
 */
public class Singleton_02 {

    /**
     * 实例
     */
    private static Singleton_02 instance;

    /**
     * 私有化构造方法
     */
    private Singleton_02() {
    }

    /**
     * 添加线程安全锁，重量级，多线程下会影响效率
     * @return
     */
    public static synchronized Singleton_02 getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Singleton_02();
        }
        return instance;
    }
}

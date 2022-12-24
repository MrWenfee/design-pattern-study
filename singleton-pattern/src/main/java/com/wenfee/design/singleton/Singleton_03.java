package com.wenfee.design.singleton;

/**
 * @author Wenfee
 * @date 2022/12/24
 * <p>
 * 单例模式- 饿汉模式
 * 线程安全：安全
 */
public class Singleton_03 {

    private static Singleton_03 instance = new Singleton_03();

    private Singleton_03() {
    }

    public static Singleton_03 getInstance() {
        return instance;
    }
}

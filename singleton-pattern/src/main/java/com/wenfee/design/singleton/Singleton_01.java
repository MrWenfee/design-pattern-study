package com.wenfee.design.singleton;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author Wenfee
 * @date 2022/12/24
 * <p>
 * 单例模式- 懒汉模式
 * 线程安全: 不安全
 */
public class Singleton_01 {

    /**
     * 实例
     */
    private static Singleton_01 instance;

    /**
     * 私有化构造方法
     */
    private Singleton_01() {
    }

    /**
     * 懒加载
     *
     * @return
     */
    public static Singleton_01 getInstance() {
        if (ObjectUtil.isNull(instance)) {
            instance = new Singleton_01();
        }
        return instance;
    }
}

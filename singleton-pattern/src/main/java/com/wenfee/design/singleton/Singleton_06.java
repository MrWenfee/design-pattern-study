package com.wenfee.design.singleton;

import cn.hutool.core.util.ObjectUtil;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author Wenfee
 * @date 2022/12/24
 * <p>
 * 单例模式
 * 线程安全： 安全
 * 原子引用类型方式实现; CAS方式实现;
 */
public class Singleton_06 {

    private static final AtomicReference<Singleton_06> instance = new AtomicReference<>();

    private Singleton_06() {
    }

    /**
     * 自旋实现
     *
     * @return
     */
    public static Singleton_06 getInstance() {
        for (; ; ) {
            Singleton_06 object = instance.get();
            if (ObjectUtil.isNotNull(object)) {
                return object;
            }
            instance.compareAndSet(null, new Singleton_06());
        }
    }

    public static void main(String[] args) {

        for (int i = 10; i < 100; i++) {
            new Thread(() -> {
                System.out.println("当前线程: " + Thread.currentThread().getName() + "; " + Singleton_06.getInstance());
            }, String.valueOf(i)).start();
        }
    }
}

package com.wenfee.design.singleton;

/**
 * @author Wenfee
 * @date 2022/12/24
 * <p>
 * 单例模式- 饿汉模式
 * 线程安全：安全
 * 静态内部类实现
 */
public class Singleton_04 {

    private static class SingletonHolder {
        private static Singleton_04 instance = new Singleton_04();
    }

    private Singleton_04() {
    }

    /**
     * 1. 使⽤类的静态内部类实现的单例模式，既保证了线程安全有保证了懒加载，同时不会因为加锁的⽅式耗费性能。
     * 2. 为JVM虚拟机可以保证多线程并发访问的正确性，也就是⼀个类的构造⽅法在多线程环境下可以被正确的加载。
     * 3. 此种⽅式也是⾮常推荐使⽤的⼀种单例模式
     *
     * @return
     */
    public static Singleton_04 getInstance() {
        return SingletonHolder.instance;
    }
}

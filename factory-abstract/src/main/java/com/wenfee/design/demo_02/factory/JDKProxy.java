package com.wenfee.design.demo_02.factory;

import java.lang.reflect.Proxy;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 完成代理类，同时对于使⽤哪个集群有外部通过⼊参进⾏传递
 */
public class JDKProxy {

    /**
     * @param interfaceClass
     * @param cacheAdapter   {@link ICacheAdapter}
     * @param <T>
     * @return 代理实例
     * @throws Exception
     * @deprecated 动态代理
     */
    public <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) {
        JDKInvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        // 类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // 获得实现的接口
        Class<?>[] interfacesClasses = interfaceClass.getInterfaces();
        // 实现的第一个接口：ICacheAdapter
        Class[] classes = new Class[]{interfacesClasses[0]};
        return (T) Proxy.newProxyInstance(classLoader, classes, handler);
    }
}

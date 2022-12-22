package com.wenfee.design.demo_02.factory;

import com.wenfee.design.demo_02.utils.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Wenfee
 * @date 2022/12/22
 */
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 处理方法形参
        Method invokeMethod = ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args));

        // 拿到service方法名，实际交给适配器 ICacheAdapter 执行相同的方法
        return invokeMethod.invoke(cacheAdapter, args);
    }
}

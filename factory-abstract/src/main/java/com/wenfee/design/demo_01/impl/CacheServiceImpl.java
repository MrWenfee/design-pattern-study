package com.wenfee.design.demo_01.impl;

import com.wenfee.design.common.RedisUtils;
import com.wenfee.design.common.matter.EGM;
import com.wenfee.design.common.matter.IIR;
import com.wenfee.design.demo_01.ICacheService;

import java.util.concurrent.TimeUnit;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * EGM集群 和 IIR集群的 获取和设置缓存方法名不一样，通过 if 判断 redisType 去调用 相应的缓存集群
 */
public class CacheServiceImpl implements ICacheService {

    private RedisUtils redisUtils = new RedisUtils();

    private EGM egm = new EGM();

    private IIR iir = new IIR();

    @Override
    public String get(String key, int redisType) {
        if (1 == redisType) {
            return egm.gain(key);
        }

        if (2 == redisType) {
            return iir.get(key);
        }

        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value, int redisType) {
        if (1 == redisType) {
            egm.set(key, value);
            return;
        }

        if (2 == redisType) {
            iir.set(key, value);
            return;
        }

        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType) {
        if (1 == redisType) {
            egm.setEx(key, value, timeout, timeUnit);
            return;
        }

        if (2 == redisType) {
            iir.setExpire(key, value, timeout, timeUnit);
            return;
        }

        redisUtils.set(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key, int redisType) {
        if (1 == redisType) {
            egm.delete(key);
            return;
        }

        if (2 == redisType) {
            iir.del(key);
            return;
        }

        redisUtils.del(key);
    }
}

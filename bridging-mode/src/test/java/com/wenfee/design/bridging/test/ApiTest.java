package com.wenfee.design.bridging.test;

import cn.hutool.core.util.IdUtil;
import com.wenfee.design.bridging.demo_01.PayController;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Wenfee
 * @date 2022/12/26
 */
public class ApiTest {

    @Test
    public void test_demo_01() {
        PayController pay = new PayController();

        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        pay.doPay("weixin_20221226", IdUtil.getSnowflakeNextIdStr(), new BigDecimal(100), 1, 2);

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        pay.doPay("jlu19dlxo111", IdUtil.getSnowflakeNextIdStr(), new BigDecimal(100), 2, 3);
    }
}

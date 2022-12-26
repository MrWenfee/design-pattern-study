package com.wenfee.design.bridging.test;

import cn.hutool.core.util.IdUtil;
import com.wenfee.design.bridging.demo_01.PayController;
import com.wenfee.design.bridging.demo_02.channel.Pay;
import com.wenfee.design.bridging.demo_02.channel.WxPay;
import com.wenfee.design.bridging.demo_02.channel.ZfbPay;
import com.wenfee.design.bridging.demo_02.mode.PayFaceMode;
import com.wenfee.design.bridging.demo_02.mode.PayFingerprintMode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author Wenfee
 * @date 2022/12/26
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_demo_01() {
        PayController pay = new PayController();

        System.out.println("\r\n模拟测试场景: 微信支付 --> 人脸方式;");
        pay.doPay("weixin_20221226", IdUtil.getSnowflakeNextIdStr(), new BigDecimal(100), 1, 2);

        System.out.println("\r\n模拟测试场景: 支付宝支付 --> 指纹方式;");
        pay.doPay("Glu19dWxt111", IdUtil.getSnowflakeNextIdStr(), new BigDecimal(100), 2, 3);
    }

    @Test
    public void test_demo_02() {
        logger.info("模拟测试场景; 微信支付、人脸方式. ");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_20221226", "10000012262257", new BigDecimal(100));

        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");

        logger.info("模拟测试场景; 支付宝支付、指纹方式. ");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("Glu19dWxt111", "10000012262258", new BigDecimal(100));
    }

}

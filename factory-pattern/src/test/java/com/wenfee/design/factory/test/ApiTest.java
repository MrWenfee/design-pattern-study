package com.wenfee.design.factory.test;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.wenfee.design.factory.demo_01.AwardRequest;
import com.wenfee.design.factory.demo_01.AwardResponse;
import com.wenfee.design.factory.demo_01.PrizeController;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 单元测试- 工程模式
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    /**
     * demo_01 是通过if进行判断发放什么类型的奖品
     */
    @Test
    public void test_factory_demo_01() {
        PrizeController prizeController = new PrizeController();

        // 模拟发放优惠券测试
        logger.info("单元测试 模拟发放 <优惠卷> 测试");
        AwardRequest req01 = new AwardRequest();
        req01.setUserId("10001");
        req01.setAwardType(1);
        req01.setAwardNumber("EGM" + IdUtil.getSnowflakeNextIdStr());
        req01.setBizId(IdUtil.getSnowflakeNextIdStr());
        AwardResponse awardRes01 = prizeController.awardToUser(req01);

        logger.info("优惠卷请求参数：{}", JSON.toJSON(req01));
        logger.info("优惠卷测试结果：{}", JSON.toJSON(awardRes01));

        // 换行输出
        format();

        // 模拟方法实物商品
        logger.info("单元测试 模拟发放 <实物商品> 测试");
        AwardRequest req02 = new AwardRequest();
        req02.setUserId("10001");
        req02.setAwardType(2);
        req02.setAwardNumber(IdUtil.getSnowflakeNextIdStr());
        req02.setBizId(IdUtil.getSnowflakeNextIdStr());
        req02.setExtMap(new HashMap<String, String>() {{
            put("consigneeUserName", "张三");
            put("consigneeUserPhone", "12345678901");
            put("consigneeUserAddress", "广东省.深圳市.龙岗区.XX街道.XXX小区.#00-2022");
        }});

        AwardResponse awardRes02 = prizeController.awardToUser(req02);
        logger.info("实物商品 请求参数：{}", JSON.toJSON(req02));
        logger.info("实物商品测试结果：{}", JSON.toJSON(awardRes02));

        // 换行输出
        format();

        logger.info("单元测试 模拟发放 <第三方兑换卡(爱奇艺)> 测试");
        AwardRequest req03 = new AwardRequest();
        req03.setUserId("10001");
        req03.setAwardType(3);
        req03.setAwardNumber(IdUtil.simpleUUID());

        AwardResponse awardRes03 = prizeController.awardToUser(req03);
        logger.info("第三方兑换卡(爱奇艺) 请求参数：{}", JSON.toJSON(req03));
        logger.info("第三方兑换卡(爱奇艺) 测试结果：{}", JSON.toJSON(awardRes03));
    }

    /**
     * 控制换行格式化输出
     */
    public void format() {
        System.out.println();
        System.out.println(" * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
    }
}

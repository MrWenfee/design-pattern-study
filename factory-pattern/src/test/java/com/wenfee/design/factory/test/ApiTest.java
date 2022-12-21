package com.wenfee.design.factory.test;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.wenfee.design.factory.demo_01.AwardRequest;
import com.wenfee.design.factory.demo_01.AwardResponse;
import com.wenfee.design.factory.demo_01.PrizeController;
import com.wenfee.design.factory.demo_02.StoreFactory;
import com.wenfee.design.factory.demo_02.service.ICommodityService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

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
     * 通过 实现接口方式(奖品类型实现同一个接口，父类引用指向子类对象方式) 优化工程模式
     */
    @Test
    public void test_factory_demo_02() throws Exception {
        StoreFactory storeFactory = new StoreFactory();

        // 1. 优惠券
        ICommodityService commodityService_1 = storeFactory.getCommodityService(1);
        commodityService_1.sendCommodity("10001", "EGM" + IdUtil.getSnowflakeNextIdStr(), IdUtil.getSnowflakeNextIdStr(), null);

        format();

        // 2. 实物商品
        ICommodityService commodityService_2 = storeFactory.getCommodityService(2);
        Map<String,String> extMap = new HashMap<String,String>();
        extMap.put("consigneeUserName", "李四");
        extMap.put("consigneeUserPhone", "12345678907");
        extMap.put("consigneeUserAddress", "广东省.深圳市.龙岗区.XX街道.XXX小区.#00-2022");

        commodityService_2.sendCommodity("10001",IdUtil.getSnowflakeNextIdStr(),IdUtil.getSnowflakeNextIdStr(),new HashMap<String, String>() {{
            extMap.put("consigneeUserName", "王五");
            extMap.put("consigneeUserPhone", "12345678907");
            extMap.put("consigneeUserAddress", "广东省.深圳市.龙岗区.XX街道.XXX小区.#00-2022");
        }});

        format();

        // 3. 第三方兑换卡(爱奇艺)
        ICommodityService commodityService_3 = storeFactory.getCommodityService(3);
        commodityService_3.sendCommodity("10001",IdUtil.simpleUUID(),null,null);
    }

    /**
     * 控制换行格式化输出
     */
    public void format() {
        System.out.println();
        System.out.println(" * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
    }
}

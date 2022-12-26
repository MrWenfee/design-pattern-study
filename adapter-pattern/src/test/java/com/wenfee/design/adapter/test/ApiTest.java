package com.wenfee.design.adapter.test;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.wenfee.design.adapter.common.mq.Account;
import com.wenfee.design.adapter.common.mq.OrderMq;
import com.wenfee.design.adapter.demo_02.MQAdapter;
import com.wenfee.design.adapter.demo_02.OrderAdapterService;
import com.wenfee.design.adapter.demo_02.RebateInfo;
import com.wenfee.design.adapter.demo_02.impl.InsideOrderServiceImpl;
import com.wenfee.design.adapter.demo_02.impl.POPOrderAdapterServiceImpl;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Wenfee
 * @date 2022/12/24
 */
public class ApiTest {

    @Test
    public void test_MQAdapter() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ParseException {

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = s.parse("2022-12-24 20:20:16");


        Account account = new Account();
        account.setNumber("100001");
        account.setAddress("xx省.xx市.xx区.五道口职业技术学院");
        account.setAccountDate(parse);
        account.setDesc("在校开户");

        HashMap<String, String> link01 = new HashMap<String, String>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");
        RebateInfo rebateInfo01 = MQAdapter.filter(account.toString(), link01);
        System.out.println("mq.account(适配前)" + account.toString());
        System.out.println("mq.account(适配后)" + JSON.toJSONString(rebateInfo01));

        System.out.println("");

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("100001");
        orderMq.setSku(IdUtil.getSnowflakeNextIdStr());
        orderMq.setOrderId(IdUtil.getSnowflakeNextIdStr());
        orderMq.setCreateOrderTime(parse);

        HashMap<String, String> link02 = new HashMap<String, String>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");
        RebateInfo rebateInfo02 = MQAdapter.filter(orderMq.toString(), link02);
        System.out.println("mq.orderMq(适配前)" + orderMq.toString());
        System.out.println("mq.orderMq(适配后)" + JSON.toJSONString(rebateInfo02));
    }

    @Test
    public void test_itfAdapter() {
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();
        System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirst("100001"));

        OrderAdapterService insideOrderService = new InsideOrderServiceImpl();
        System.out.println("判断首单，接口适配(自营)：" + insideOrderService.isFirst("100001"));
    }

}

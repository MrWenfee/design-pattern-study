package com.wenfee.design.prototype.test;

import cn.hutool.core.util.IdUtil;
import com.wenfee.design.prototype.demo_01.QuestionBankController;
import org.junit.Test;

/**
 * @author Wenfee
 * @date 2022/12/23
 * <p>
 * 单元测试- 原型模式
 */
public class ApiTest {

    /**
     * 测试 demo_01
     */
    @Test
    public void test_prototype_demo_01() {
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createTestPage("张三", IdUtil.getSnowflakeNextIdStr()));

        format();

        System.out.println(questionBankController.createTestPage("李四", IdUtil.getSnowflakeNextIdStr()));

        format();

        System.out.println(questionBankController.createTestPage("王五", IdUtil.getSnowflakeNextIdStr()));
    }

    /**
     * 控制换行格式化输出
     */
    public void format() {
        System.out.println();
        System.out.println(" * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
    }
}

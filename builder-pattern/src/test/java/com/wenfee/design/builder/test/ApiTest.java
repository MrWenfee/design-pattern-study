package com.wenfee.design.builder.test;

import com.wenfee.design.builder.demo_01.DecorationPackageController;
import com.wenfee.design.builder.demo_02.Builder;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 单元测试- 建造者模式
 */
public class ApiTest {

    /**
     * if判断逻辑实现
     */
    @Test
    public void test_builder_demo_01() {
        DecorationPackageController decoration = new DecorationPackageController();

        // 豪华欧式
        System.out.println(decoration.getMatterList(new BigDecimal("132.52"), 1));

        // 轻奢田园
        System.out.println(decoration.getMatterList(new BigDecimal("98.25"), 2));

        // 现代简约
        System.out.println(decoration.getMatterList(new BigDecimal("85.43"), 3));
    }

    /**
     * 通过 Builder 类方法去实现建造者方式
     */
    @Test
    public void test_builder_demo_02() {
        Builder builder = new Builder();

        // 豪华欧式
        System.out.println(builder.levelOne(132.52D).getDetail());

        // 轻奢田园
        System.out.println(builder.levelTwo(98.25D).getDetail());

        // 现代简约
        System.out.println(builder.levelThree(85.43D).getDetail());
    }
}

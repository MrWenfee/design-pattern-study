package com.wenfee.design.builder.common;

import java.math.BigDecimal;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 装修材料
 */
public interface Matter {

    /**
     * 场景；地板、地砖、涂料、吊顶
     */
    String scene();

    /**
     * 品牌
     */
    String brand();

    /**
     * 型号
     */
    String model();

    /**
     * 平米报价
     */
    BigDecimal price();

    /**
     * 描述
     */
    String desc();
}

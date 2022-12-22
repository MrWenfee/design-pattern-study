package com.wenfee.design.builder.demo_02;

import com.wenfee.design.builder.common.Matter;

/**
 * @author Wenfee
 * @date 2022/12/22
 */
public interface IMenu {

    /**
     * 吊顶
     */
    IMenu appendCeiling(Matter matter);

    /**
     * 涂料
     *
     * @param matter
     * @return
     */
    IMenu appendCoat(Matter matter);

    /**
     * 地板
     *
     * @param matter
     * @return
     */
    IMenu appendFloor(Matter matter);

    /**
     * 地砖
     *
     * @param matter
     * @return
     */
    IMenu appendTile(Matter matter);

    /**
     * 明细
     *
     * @return
     */
    String getDetail();
}

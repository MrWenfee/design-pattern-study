package com.wenfee.design.builder.demo_02;

import com.wenfee.design.builder.common.ceiling.LevelOneCeiling;
import com.wenfee.design.builder.common.ceiling.LevelTwoCeiling;
import com.wenfee.design.builder.common.coat.DuluxCoat;
import com.wenfee.design.builder.common.coat.LiBangCoat;
import com.wenfee.design.builder.common.floor.ShengXiangFloor;
import com.wenfee.design.builder.common.tile.DongPengTile;
import com.wenfee.design.builder.common.tile.MarcoPoloTile;

/**
 * @author Wenfee
 * @date 2022/12/22
 */
public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                // 吊顶，二级顶
                .appendCeiling(new LevelTwoCeiling())
                // 涂料，多乐士
                .appendCoat(new DuluxCoat())
                // 地板，圣象
                .appendFloor(new ShengXiangFloor());
    }

    public IMenu levelTwo(Double area) {
        return new DecorationPackageMenu(area, "轻奢田园")
                // 吊顶，二级顶
                .appendCeiling(new LevelTwoCeiling())
                // 涂料，立邦
                .appendCoat(new LiBangCoat())
                // 地砖，马可波罗
                .appendTile(new MarcoPoloTile());
    }

    public IMenu levelThree(Double area) {
        return new DecorationPackageMenu(area, "现代简约")
                // 吊顶，二级顶
                .appendCeiling(new LevelOneCeiling())
                // 涂料，立邦
                .appendCoat(new LiBangCoat())
                // 地砖，东鹏
                .appendTile(new DongPengTile());
    }
}

package com.wenfee.design.builder.demo_01;

import com.wenfee.design.builder.common.Matter;
import com.wenfee.design.builder.common.ceiling.LevelOneCeiling;
import com.wenfee.design.builder.common.ceiling.LevelTwoCeiling;
import com.wenfee.design.builder.common.coat.DuluxCoat;
import com.wenfee.design.builder.common.coat.LiBangCoat;
import com.wenfee.design.builder.common.floor.ShengXiangFloor;
import com.wenfee.design.builder.common.tile.DongPengTile;
import com.wenfee.design.builder.common.tile.MarcoPoloTile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wenfee
 * @date 2022/12/22
 */
public class DecorationPackageController {

    public String getMatterList(BigDecimal area, Integer level) {

        // 装修清单
        List<Matter> list = new ArrayList<Matter>();

        // 装修价格
        BigDecimal price = BigDecimal.ZERO;

        // 豪华欧式
        if (1 == level) {

            // 吊顶，二级顶
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();

            // 涂料，多乐士
            DuluxCoat duluxCoat = new DuluxCoat();

            // 地板，圣象
            ShengXiangFloor shengXiangFloor = new ShengXiangFloor();

            list.add(levelTwoCeiling);
            list.add(duluxCoat);
            list.add(shengXiangFloor);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(duluxCoat.price()));
            price = price.add(area.multiply(shengXiangFloor.price()));

        }

        // 轻奢田园
        if (2 == level) {
            // 吊顶，二级顶
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();
            // 涂料，立邦
            LiBangCoat liBangCoat = new LiBangCoat();
            // 地砖，马可波罗
            MarcoPoloTile marcoPoloTile = new MarcoPoloTile();

            list.add(levelTwoCeiling);
            list.add(liBangCoat);
            list.add(marcoPoloTile);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(liBangCoat.price()));
            price = price.add(area.multiply(marcoPoloTile.price()));

        }

        // 现代简约
        if (3 == level) {
            // 吊顶，二级顶
            LevelOneCeiling levelOneCeiling = new LevelOneCeiling();
            // 涂料，立邦
            LiBangCoat liBangCoat = new LiBangCoat();
            // 地砖，东鹏
            DongPengTile dongPengTile = new DongPengTile();

            list.add(levelOneCeiling);
            list.add(liBangCoat);
            list.add(dongPengTile);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelOneCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(liBangCoat.price()));
            price = price.add(area.multiply(dongPengTile.price()));
        }

        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "装修清单" + "\r\n" +
                "套餐等级：" + level + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");

        for (Matter matter : list) {
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、平米价格：").append(matter.price()).append(" 元。\n");
        }

        return detail.toString();

    }
}

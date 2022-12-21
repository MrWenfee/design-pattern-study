package com.wenfee.design.factory.demo_02;

import com.wenfee.design.factory.demo_02.service.ICommodityService;
import com.wenfee.design.factory.demo_02.service.impl.CardCommodityServiceImpl;
import com.wenfee.design.factory.demo_02.service.impl.CouponCommodityServiceImpl;
import com.wenfee.design.factory.demo_02.service.impl.GoodsCommodityServiceImpl;

/**
 * @author Wenfee
 * @date 2022/12/22
 * <p>
 * 商品工厂
 */
public class StoreFactory {

    public ICommodityService getCommodityService(Integer commodityType) {
        ICommodityService iCommodityService = null;
        switch (commodityType) {
            case 1:
                iCommodityService = new CouponCommodityServiceImpl();
                break;
            case 2:
                iCommodityService = new GoodsCommodityServiceImpl();
                break;
            case 3:
                iCommodityService = new CardCommodityServiceImpl();
                break;
            default:
                throw new RuntimeException("不存在的商品服务类型");
        }
        return iCommodityService;
    }

    }

package com.jbf.shopping.demo.superMarket;

import com.jbf.shopping.demo.fruit.Coupon;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description: 超市买食物
 * @author: LuAn
 * @date: 2024/6/22
 */
public class FoodShop implements Shop<FoodShop, Coupon>{

    @Override
    public BigDecimal calculate(List<FoodShop> items) {
        return null;
    }
    @Override
    public BigDecimal calculate(List<FoodShop> items, Coupon coupon) {
        return null;
    }
}

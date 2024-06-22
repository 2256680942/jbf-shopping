package com.jbf.shopping.demo.superMarket;

import com.jbf.shopping.demo.fruit.Coupon;
import com.jbf.shopping.demo.fruit.Fruit;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description: 超市买水果
 * @author: LuAn
 * @date: 2024/6/21
 */
@Slf4j
public class FruitShop implements Shop<Fruit,Coupon>{

    // 1-2 购买水果计算总价
    public  BigDecimal calculate(List<Fruit>fruits) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Fruit fruit : fruits) {
            totalPrice=totalPrice.add(fruit.getPricePerJin().multiply(new BigDecimal(String.valueOf(fruit.getNumber()))));
        }
        return totalPrice;
    }

    // 3-4: C用户草莓8折、D用户满100减10
    public BigDecimal calculate(List<Fruit>fruits, Coupon coupon) {
        BigDecimal totalPrice = calculate(fruits);
        switch (coupon.getType()){
            //满减券
            case 1->{
                if (coupon.getBase()==0){
                    return totalPrice.subtract(new BigDecimal(String.valueOf(coupon.getQuote()))); // 无门槛减10;
                }
                else if (totalPrice.compareTo(new BigDecimal(String.valueOf(coupon.getBase())))!=-1) {
                    totalPrice=totalPrice.subtract(new BigDecimal(String.valueOf(coupon.getQuote()))); // 满100减10
                }
            }
            //折扣券
            case 2 -> {
                if (coupon.getBase() == 0) {
                    return totalPrice.multiply(new BigDecimal(String.valueOf((coupon.getQuote())/ 100.00)));
                }else {
                    return totalPrice.subtract(getDisCountPrice(fruits,coupon));
                }
            }
        }
        return totalPrice;
    }

    // 计算出折扣优惠的金额
    private BigDecimal getDisCountPrice(List<Fruit>fruits,Coupon coupon) {
        BigDecimal pricePerJin = fruits.get(coupon.getBase()-1).getPricePerJin();
        int number = fruits.get(coupon.getBase()-1).getNumber();
        BigDecimal fruitPrice = pricePerJin.multiply(new BigDecimal(String.valueOf(number))); // 水果价格
        log.info("某个水果的价格:{}",fruitPrice);
        return fruitPrice.multiply(new BigDecimal(String.valueOf((100 - coupon.getQuote()) / 100.00))); // 优惠的价格
    }
}

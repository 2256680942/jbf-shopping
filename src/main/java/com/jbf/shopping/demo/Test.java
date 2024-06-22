package com.jbf.shopping.demo;

import com.jbf.shopping.demo.fruit.Coupon;
import com.jbf.shopping.demo.fruit.Fruit;
import com.jbf.shopping.demo.superMarket.FruitShop;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 测试
 * @author: LuAn
 * @date: 2024/6/22
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        FruitShop fruitShop = new FruitShop();

        List<Fruit> fruits = new ArrayList<>();  // 苹果、草莓
        Fruit apple = new Fruit("Apple",new BigDecimal("8"),2);
        Fruit strawberry = new Fruit("Strawberry",new BigDecimal("13"),3);
        fruits.add(apple);
        fruits.add(strawberry);

        List<Fruit> fruits1 = new ArrayList<>(); // 苹果、草莓、芒果
        Fruit apple1 = new Fruit("Apple",new BigDecimal("8"),2);
        Fruit strawberry1 = new Fruit("Strawberry",new BigDecimal("13"),3);
        Fruit mango1  = new Fruit("Mango",new BigDecimal("20"),4);
        fruits1.add(apple1);
        fruits1.add(strawberry1);
        fruits1.add(mango1);

        Coupon reduce = new Coupon(1,100,10); //满100减10券
        Coupon noCondition = new Coupon(1, 0, 10); // 无门槛券
        Coupon someDiscount = new Coupon(2, 2, 80); // 草莓 8折券
        Coupon discount = new Coupon(2, 0, 10); //折扣 全折扣券

        log.info("顾客A的总价: {}", fruitShop.calculate(fruits)); // 示例A 16+39 = 55
        log.info("顾客B的总价: {}", fruitShop.calculate(fruits1));// 示例B 16+39+80 = 135

        log.info("顾客C的总价: {}", fruitShop.calculate(fruits1, someDiscount)); // 示例C草莓8折 16+31.2+80=127.2
        log.info("顾客G的总价: {}", fruitShop.calculate(fruits1, discount)); // 示例G全折扣 135/10=13.5

        log.info("顾客D的总价：{}", fruitShop.calculate(fruits1, reduce));//   示例D 满100减10 135-10=125
        log.info("顾客E的总价：{}", fruitShop.calculate(fruits, reduce));//   示例E 未满100 原价55
        log.info("顾客F的总价：{}", fruitShop.calculate(fruits, noCondition));  // 示例F 无门槛满减10  55-10=45
    }
}

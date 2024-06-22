package com.jbf.shopping.demo.superMarket;

import java.math.BigDecimal;
import java.util.List;

/**
 *  超市购买
 */
public interface Shop<T, C> {
    BigDecimal calculate(List<T> items); // 计算总价
    BigDecimal calculate(List<T> items, C coupon); // 优惠价
}

package com.jbf.shopping.demo.fruit;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 优惠券
 * @author: LuAn
 * @date: 2024/6/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
    /**
     * 1 表示 满减卷   2  表示折扣卷
     */
    @Min(1)
    private  int  type;
    /**
     * 配合 类型使用 如果满减 0 表示表示无门槛  大于0表示满减 如果折扣券 0 全部水果 1 苹果 2 草莓 3 芒果
     */
    @Min(0)
    private  int  base;
    /**
     *  配合 类型使用 如果 满减  表示金额 如果 折扣 则表示quote/100.00折
     */
    @Min(0)
    private int quote;
}

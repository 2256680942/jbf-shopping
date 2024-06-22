package com.jbf.shopping.demo.fruit;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @description: 水果
 * @author: LuAn
 * @date: 2024/6/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fruit {
    @Min(0)
    private String name; // 种类
    @Min(0)
    private BigDecimal pricePerJin; // 元/斤
    @Min(0)
    private int number; //多少斤

}

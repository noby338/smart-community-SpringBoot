package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description 单价表
 * @Author noby
 * @Date 2022/7/6 20:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilPrice {
    private Integer id;
    private String name;//费用项目
    private List<GradientPrice> gradientPriceList;//该费用项目的所有价格梯度
}

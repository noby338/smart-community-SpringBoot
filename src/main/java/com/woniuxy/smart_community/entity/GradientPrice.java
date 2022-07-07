package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 单价表
 * @Author noby
 * @Date 2022/7/7 9:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradientPrice {
    private Integer id;
    private String name;
    private Integer utilId;//单价id
    private Double beginning;//本价格梯度的开始(包含)
    private Double end;//本价格梯度的结束(不包含)
    private Double price;//本价格梯度的价格
}

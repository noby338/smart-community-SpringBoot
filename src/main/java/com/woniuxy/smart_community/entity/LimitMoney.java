package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 物业卡费用限制
 * @Author noby
 * @Date 2022/7/13 19:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LimitMoney {
    private Integer id;
    private Double limitMoney;
}

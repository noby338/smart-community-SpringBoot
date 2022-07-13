package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/11 10:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyCard {
    private Integer id;
    private String cardNumber;//房卡编号
    private Integer houseId;
    private Double lastMoney;//余额
    private Double limitMoney;//欠费限制
    private Integer state;
}

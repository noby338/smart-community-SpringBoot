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
    private HouseHold houseHold;//房主
    private Double lastMoney;//余额
    private LimitMoney limitMoney;//欠费限制对象
    private Integer state;
}

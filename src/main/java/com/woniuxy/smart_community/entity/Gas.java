package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 气费表
 * @Author noby
 * @Date 2022/7/6 15:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gas {
    private Integer id;
    private Integer houseId;//房屋id
    private String month;//缴费的年月记录
    private Double nowMonthNums;//本月用量
    private Double nowPrices;//本月待缴费
    private Integer state;//1：正常，2：欠费，3：禁用
    private Integer utilPriceId;//单价表id
}

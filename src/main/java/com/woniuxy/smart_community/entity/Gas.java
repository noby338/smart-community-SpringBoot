package com.woniuxy.smart_community.entity;

/**
 * @Description 气费表
 * @Author noby
 * @Date 2022/7/6 15:25
 */
public class Gas {
    private int id;
    private int houseId;//房屋id
    private String month;//缴费的年月记录
    private Double nowMonthNums;//本月用量
    private Double nowPrices;//本月待缴费
    private int state;//1：正常，2：欠费，3：禁用
}

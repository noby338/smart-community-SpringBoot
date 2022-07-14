package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.GradientPrice;

import java.math.BigDecimal;

/**
 * @Description 单价梯度
 * @Author noby
 * @Date 2022/7/7 19:08
 */
public interface GradientPriceService {
    /**
     * 通过单价梯度对象修改价格梯度
     * @param gradientPrice 梯度对象
     */
    void updateByGradientPrice(GradientPrice gradientPrice);

    /**
     * 根据梯度对象插入梯度，
     * 梯度对象中不 id 和 end 留空
     * @param gradientPrice 梯度对象
     */
    void insert(GradientPrice gradientPrice);

    /**
     * 通过 id 删除某价格梯度
     * @param id 价格梯度 id
     */
    void delectById(int id);

}

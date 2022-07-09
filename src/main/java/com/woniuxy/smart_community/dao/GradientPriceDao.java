package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.GradientPrice;

import java.util.List;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/7 19:00
 */
public interface GradientPriceDao {
    /**
     * 根据单价梯度对象修改单价梯度
     * @param gradientPrice 单价梯度
     */
    void updateByGradientPrice(GradientPrice gradientPrice);

    /**
     * 根据单价Id查询单价所有梯度
     * @param utilId 单价Id
     * @return 单价所有梯度集合
     */
    List<GradientPrice> selectByUtilId(int utilId);
}

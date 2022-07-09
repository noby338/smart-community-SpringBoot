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
     * 通过单价 Id 和用量计算，该 service 通过数据库中的单价梯度计算价格并返回
     * @param utilId 单价 ID
     * @param quantity 用量
     * @return 价格
     */
    BigDecimal getPriceByUtilIdQuantity(int utilId,double quantity);

}

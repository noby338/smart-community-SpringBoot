package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.UtilPrice;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description 单价service
 * @Author noby
 * @Date 2022/7/7 10:23
 */
public interface UtilPriceService {
    /**
     * 查询所有单价
     * @return 单价对象集合
     */
    List<UtilPrice> selectAll();
    /**
     * 通过单价 Id 和用量计算，该 service 通过数据库中的单价梯度计算价格并返回
     * @param utilId 单价 ID
     * @param quantity 用量
     * @return 价格
     */
    BigDecimal getPriceByUtilIdQuantity(int utilId, double quantity);

    /**
     * 获取某项费用的用量价格二维数组
     * @return
     */
    List<double[]> getQuantityAndCostArray(int utilId);
}

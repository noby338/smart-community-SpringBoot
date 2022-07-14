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
     *
     * @param gradientPrice 单价梯度
     */
    void updateByGradientPrice(GradientPrice gradientPrice);

    /**
     * 根据单价梯度id查询单价梯度
     *
     * @param id 单价梯度id
     * @return 查询单价梯度对象
     */
    GradientPrice selectById(int id);

    /**
     * 新增单价梯度
     *
     * @param gradientPrice 单价梯度对象
     */
    void insert(GradientPrice gradientPrice);

    /**
     * 通过 id 值删除梯度
     * @param id 梯度 id
     */
    void deleteById(int id);
}

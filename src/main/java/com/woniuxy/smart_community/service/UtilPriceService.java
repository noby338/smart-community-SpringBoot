package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.UtilPrice;

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
}

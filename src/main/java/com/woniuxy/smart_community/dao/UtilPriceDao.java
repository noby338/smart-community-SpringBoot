package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.UtilPrice;

import java.util.List;

/**
 * @Description 单价dao
 * @Author noby
 * @Date 2022/7/7 9:28
 */
public interface UtilPriceDao {
    /**
     * 查询所用单价
     * @return 单价对象
     */
    List<UtilPrice> selectAll();
}

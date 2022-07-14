package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.GradientPrice;
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
    /**
     * 根据单价Id查询单价对象
     * @param id 单价Id
     * @return 单价对象
     */
    UtilPrice selectById(int id);
}

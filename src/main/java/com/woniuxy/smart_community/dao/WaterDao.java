package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.Gas;
import com.woniuxy.smart_community.entity.Water;

/**
 * @Description 水费表
 * @Author noby
 * @Date 2022/7/8 14:47
 */
public interface WaterDao {
    /**
     * 插入水费表
     * @param water 水费对象
     */
    void insert(Water water);
}

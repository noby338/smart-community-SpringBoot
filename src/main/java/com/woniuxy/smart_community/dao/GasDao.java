package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.Gas;

/**
 * @Description 气费表
 * @Author noby
 * @Date 2022/7/8 14:36
 */
public interface GasDao {
    /**
     * 插入气费表
     * @param gas 气费对象
     */
    void insert(Gas gas);
}

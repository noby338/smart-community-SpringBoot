package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.HouseUnit;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/8 18:39
 */
public interface HouseUnitDao {
    void insert(HouseUnit houseUnit);
    HouseUnit selectById(int id);
}

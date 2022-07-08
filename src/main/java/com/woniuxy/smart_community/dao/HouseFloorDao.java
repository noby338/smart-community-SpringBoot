package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.HouseFloor;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/8 17:55
 */
public interface HouseFloorDao {
    void insert(HouseFloor houseFloor);
    HouseFloor selectById(int id);
}

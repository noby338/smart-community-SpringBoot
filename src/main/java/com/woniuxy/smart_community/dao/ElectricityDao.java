package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.Electricity;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/6 15:39
 */
public interface ElectricityDao {
    /**
     * 通过电费表id查询电费表
     * @param electricityId 电费表
     * @return Electricity 电费实体类
     */
    Electricity selectByElectricity(int electricityId);
}

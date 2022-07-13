package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.entity.HouseBuilding;
import com.woniuxy.smart_community.entity.HouseUnit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 电费dao
 * @Author noby
 * @Date 2022/7/6 15:39
 */
public interface ElectricityDao {
    /**
     * 通过电费表id查询电费表
     * @param electricityId 电费表
     * @return Electricity 电费对象
     */
    Electricity selectByElectricity(int electricityId);

    /**
     * 插入电费月用量
     * @param electricity 电费表
     */
    void insert(Electricity electricity);

    /**
     * 月份条件查询电表
     * @return
     */
    List<Electricity> selectByMonth(String month);
    /**
     * 月份条件查询电表
     * @return
     */
    List<Electricity> selectElectricityByHouseIdListAndMonth(
            @Param("houseIdList") List<Integer> houseIdList,@Param("month") String month);
}

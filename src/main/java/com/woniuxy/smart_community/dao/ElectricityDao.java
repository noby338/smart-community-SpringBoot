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
     * 插入电费月用量
     * @param electricity 电费表
     */
    void insert(Electricity electricity);


    /**
     * 月份及房屋id集合查询电费
     * @param houseIdList 房屋id集合
     * @param month 月份
     * @return 电费集合
     */
    List<Electricity> selectElectricityByHouseIdListAndMonth(
            @Param("houseIdList") List<Integer> houseIdList,@Param("month") String month);

    /**
     * 月份及房屋id集合查询总电费
     * @param houseIdList 房屋id集合
     * @param month 月份
     * @return 总电费
     */
    Double selectElectricitySumByHouseIdListAndMonth(
            @Param("houseIdList") List<Integer> houseIdList,@Param("month") String month);

    /**
     * 根据房屋id和月份更新状态和费用
     * @param electricity
     * @return
     */
    void updateByElectricity(Electricity electricity);

    /**
     * 根据日期和房间id设置状态电费
     * @param electricity
     */
    void updateStateById(Electricity electricity);

    /**
     * 根据房间id查出state不等于1的状态
     * @param houseId
     * @return
     */
    Electricity selectByHouseIdAndState(int houseId);
}

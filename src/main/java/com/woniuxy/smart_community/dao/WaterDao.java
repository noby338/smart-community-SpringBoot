package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.entity.Gas;
import com.woniuxy.smart_community.entity.Water;
import com.woniuxy.smart_community.service.WaterService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 月份及房屋id集合查询电费
     * @param houseIdList 房屋id集合
     * @param month 月份
     * @return 电费集合
     */
    List<Water> selectWaterByHouseIdListAndMonth(
            @Param("houseIdList") List<Integer> houseIdList, @Param("month") String month);

    /**
     * 月份及房屋id集合查询电费统计
     * @param houseIdList 房屋id集合
     * @param month 月份
     * @return 电费统计
     */
    Double selectWaterSumByHouseIdListAndMonth(
            @Param("houseIdList") List<Integer> houseIdList, @Param("month") String month);
    /**
     * 根据房屋id和月份更新状态和费用
     * @param water
     * @return
     */
    void updateByWater(Water water);

    /**
     * 根据日期和房间id设置状态水费
     * @param water
     */
    void updateStateById(Water water);

    /**
     * 根据房间id查出state不等于1的状态
     * @param houseId
     * @return
     */
    Water selectByHouseIdAndState(int houseId);
}

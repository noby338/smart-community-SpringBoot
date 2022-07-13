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
}

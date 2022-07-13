package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.Gas;
import com.woniuxy.smart_community.entity.Water;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 月份及房屋id集合查询气费
     * @param houseIdList 房屋id集合
     * @param month 月份
     * @return 气费集合
     */
    List<Gas> selectGasByHouseIdListAndMonth(
            @Param("houseIdList") List<Integer> houseIdList, @Param("month") String month);
}

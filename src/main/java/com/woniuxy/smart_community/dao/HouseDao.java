package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName -> HouseDao
 * @Author Fiver_Hu
 * @Date 2022/7/5 15:12 星期二
 * @Version 1.0
 **/
public interface HouseDao {


    /**
     * 通过主键修改房间信息数据
     *
     * @param house 实例对象
     * @return 影响行数
     */
    int updateHouse(@Param("house") House house);

    /**
     * 通过房间信息查询相关数据
     *
     * @param houseInfo 楼栋号
     * @return 实例对象
     */
    List<HouseBuilding> selectHouseByBuildingId(@Param("houseInfo") HouseInfo houseInfo);

    List<HouseBuilding> selectHouseByBuildingId();

    /**
     * 通过房间信息查询相关数据
     *
     * @param houseInfo 楼栋号
     * @return 实例对象
     */
    List<HouseUnit> selectHouseByUnitId(@Param("houseInfo") HouseInfo houseInfo);

    /**
     * 通过房间信息查询相关数据
     *
     * @param houseInfo 楼栋号
     * @return 实例对象
     */
    List<HouseFloor> selectHouseByFloorId(@Param("houseInfo") HouseInfo houseInfo);

    //孙浚钦使用---car页面
    List<House> selectAllHouseForCarShow();
}

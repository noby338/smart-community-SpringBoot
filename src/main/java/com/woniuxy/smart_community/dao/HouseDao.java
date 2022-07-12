package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.House;
import com.woniuxy.smart_community.entity.HouseBuilding;
import com.woniuxy.smart_community.entity.HouseFloor;
import com.woniuxy.smart_community.entity.HouseUnit;
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
     * @param buildingId 楼栋号
     * @return 实例对象
     */
    HouseBuilding selectHouseByBuildingId(Integer buildingId);

    /**
     * 通过房间信息查询相关数据
     *
     * @param unitId 楼栋号
     * @return 实例对象
     */
    HouseUnit selectHouseByUnitId(Integer unitId);

    /**
     * 通过房间信息查询相关数据
     *
     * @param floorId 楼栋号
     * @return 实例对象
     */
    HouseFloor selectHouseByFloorId(Integer floorId);


}

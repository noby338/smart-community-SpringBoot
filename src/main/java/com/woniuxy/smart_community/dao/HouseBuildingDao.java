package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.HouseBuilding;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author :  Fiver_Hu
 * @Date : 2022/7/9 11:02 星期六
 * @Project_Name -> smart-community
 * @Package_Name -> com.woniuxy.smart_community.dao
 * @ClassName -> HouseBuildingDao
 * @Version 1.0
 **/
public interface HouseBuildingDao {
    //添加
    int insertHouseBuilding(@Param("houseBuilding") HouseBuilding houseBuilding);
    //删除
    int deleteHouseBuilding(@Param("houseBuilding") HouseBuilding houseBuilding);
    //修改
    int updateHouseBuilding(@Param("houseBuilding") HouseBuilding houseBuilding);
    //查询
    HouseBuilding selectHouseBuilding(@Param("houseBuilding") HouseBuilding houseBuilding);

}

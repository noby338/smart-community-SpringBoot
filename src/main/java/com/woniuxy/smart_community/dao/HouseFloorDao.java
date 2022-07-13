package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.HouseFloor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/8 17:55
 */
public interface HouseFloorDao {

    //添加
    int insertHouseFloor(@Param("houseFloor") HouseFloor houseFloor);
    //删除
    int deleteHouseFloor(@Param("houseFloor") HouseFloor houseFloor);
    //修改
    int updateHouseFloor(@Param("houseFloor") HouseFloor houseFloor);
    //查询
    HouseFloor selectHouseFloor(@Param("houseFloor") HouseFloor houseFloor);


}

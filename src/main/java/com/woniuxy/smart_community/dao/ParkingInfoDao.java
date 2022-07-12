package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.ParkingInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Author: LittleCode
 * @Date:   2022/7/6  
 * @Descrition:
 */

@Mapper
public interface ParkingInfoDao {


    //分页+条件查询车位信息，返回显示
    int selectCount(@Param("parkingInfo") ParkingInfo parkingInfo);
    List<ParkingInfo> selectParkingInfoByParkingInfo(@Param("parkingInfo") ParkingInfo parkingInfo);

    //添加
    void insertParkingInfo(@Param("parkingInfo") ParkingInfo parkingInfo);

    void updateParkingInfo(@Param("parkingInfo") ParkingInfo parkingInfo);
    //假删除
    void deleteParkingInfoById(int parkId);


    //车辆页面使用查询--使用中--孙
    List<ParkingInfo> selectParkingListByOwnerId(int ownerId);
}

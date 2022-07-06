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
//    查询
    List<ParkingInfo> selectAllParkingInfo();
    List<ParkingInfo> selectParkingInfoByParkingInfo(@Param("parkingInfo") ParkingInfo parkingInfo);
    ParkingInfo selectParkingInfoByParkid(int parkid);

//    添加
    void insertParkingInfo(@Param("parkingInfo") ParkingInfo parkingInfo);
//    修改
    void updateParkingInfoByType(@Param("ptypeid") int typeid,
                                 @Param("owid") int owid,
                                 @Param("parkid") int parkid);
    void updateParkingInfo(@Param("parkingInfo") ParkingInfo parkingInfo);
//    删除


}

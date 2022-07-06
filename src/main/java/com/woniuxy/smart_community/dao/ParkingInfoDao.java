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
    int selectCount(@Param("parkingInfo") ParkingInfo parkingInfo);
    List<ParkingInfo> selectAllParkingInfo();
    List<ParkingInfo> selectParkingInfoByParkingInfo(@Param("parkingInfo") ParkingInfo parkingInfo);
    ParkingInfo selectParkingInfoByParkid(int parkId);


//    添加
    void insertParkingInfo(@Param("parkingInfo") ParkingInfo parkingInfo);
//    修改
    void updateParkingInfoByType(@Param("pTypeTd") int typeId,
                                 @Param("owId") int owId,
                                 @Param("parkId") int parkId);

    void updateParkingInfo(@Param("parkingInfo") ParkingInfo parkingInfo);


//    删除
    void deleteParkingInfoByParkid(int parkId);


}

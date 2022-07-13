package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.ParkingLot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ParkingLotDao {
//    查询
    List<ParkingLot> selectAllParkingLot();

    ParkingLot selectParkingLotById(int id);//使用

    List<ParkingLot> selectParkingLotByName(@Param("parkingName") String parkingName);


//    添加
    //添加停车场默认state=1启用状态
    void insertParkingLot(@Param("parkingLot") ParkingLot parkingLot);

//    修改
    void updateParkingLot(@Param("parkingLot") ParkingLot parkingLot);
    //更高权限管理员启用或者禁用该停车场
    void updateParkingLotState(@Param("state") int state,@Param("id") int id);

//    删除
}

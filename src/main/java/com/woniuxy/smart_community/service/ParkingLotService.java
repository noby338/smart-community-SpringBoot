package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.ParkingLot;

import java.util.List;

public interface ParkingLotService {
//    查询
    List<ParkingLot> getAllParkingLot();
    ParkingLot getParkingLotById(int id);
    List<ParkingLot> getParkingLotByName(String parkingName);


//    添加
    void addParkingLot(ParkingLot parkingLot);

//    修改  一般有管理权限才能修改
    void changeParkingLot(ParkingLot parkingLot);
    //停车场状态修改
    void changeParkingLotState(int state,int id);

//    删除
}

package com.woniuxy.smart_community.service.impl;

import com.woniuxy.smart_community.dao.ParkingInfoDao;
import com.woniuxy.smart_community.dao.ParkingLotDao;
import com.woniuxy.smart_community.entity.ParkingInfo;
import com.woniuxy.smart_community.entity.ParkingLot;
import com.woniuxy.smart_community.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    ParkingLotDao parkingLotDao;
    @Autowired
    ParkingInfoDao parkingInfoDao;

//    查询
    @Override
    public List<ParkingLot> getAllParkingLot() {
        List<ParkingLot> parkingLots = parkingLotDao.selectAllParkingLot();
        return parkingLots;
    }

    //使用
    @Override
    public ParkingLot getParkingLotById(int id) {
        ParkingLot parkingLot = parkingLotDao.selectParkingLotById(id);
        return parkingLot;
    }

    @Override
    public List<ParkingLot> getParkingLotByName(String parkingName) {
        List<ParkingLot> parkingLots = parkingLotDao.selectParkingLotByName(parkingName);
        return parkingLots;
    }

//    添加
    @Override
    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotDao.insertParkingLot(parkingLot);

    }

//    修改
    @Override
    public void changeParkingLot(ParkingLot parkingLot) {
        System.out.println("更新parkingLot表数据"+parkingLot);
        int parkNums = parkingInfoDao.selectCount(new ParkingInfo());
        int sellParkNums = parkingInfoDao.selectCountByParkingType(1);
        int hireParkNums = parkingInfoDao.selectCountByParkingType(2);
        //nowUseNums数据需要查询parking_record表
        parkingLot.setParkNums(parkNums);
        parkingLot.setSellParkNums(sellParkNums);
        parkingLot.setHireParkNums(hireParkNums);
        parkingLotDao.updateParkingLot(parkingLot);
    }

    @Override
    public void changeParkingLotState(int state, int id) {
        parkingLotDao.updateParkingLotState(state,id);
    }
}

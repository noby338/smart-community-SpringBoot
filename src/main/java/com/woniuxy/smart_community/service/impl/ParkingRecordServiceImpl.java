package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.dao.CarInfoDao;
import com.woniuxy.smart_community.dao.ParkingRecordDao;
import com.woniuxy.smart_community.entity.CarInfo;
import com.woniuxy.smart_community.entity.ForSelect;
import com.woniuxy.smart_community.entity.ParkingRecord;
import com.woniuxy.smart_community.service.ParkingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ParkingRecordServiceImpl implements ParkingRecordService {
    @Autowired
    ParkingRecordDao parkingRecordDao;
    @Autowired
    CarInfoDao carInfoDao;

    @Override
    public PageInfo<ParkingRecord> getParkingRecordsToPage(int pageIndex, int pageSize, ParkingRecord queryParkingRecord) {
        PageHelper.startPage(pageIndex, pageSize);
        Integer id = queryParkingRecord.getCarInfo().getId();
        if (id != null && !id.equals("")) {
            CarInfo carInfo = carInfoDao.selectCarIfoById(id);
            queryParkingRecord.setCarInfo(carInfo);
            System.out.println("CarInfo:" + carInfo);
        }
        List<ParkingRecord> parkingRecords = parkingRecordDao.selectParkingRecordToPage(queryParkingRecord);
        System.out.println(parkingRecords);
        PageInfo<ParkingRecord> pageInfo = new PageInfo<>(parkingRecords);
        int total = parkingRecordDao.selectCountToPage(queryParkingRecord);
        pageInfo.setTotal(total);
        return pageInfo;
    }

    @Override
    public List<ForSelect> getCarsInParkingRecord() {
        List<Integer> integers = parkingRecordDao.selectCarIdsDistinct();
        List<ForSelect> forSelects = new ArrayList<>();
        for (Integer carId : integers) {
            ForSelect forSelect = new ForSelect();
            CarInfo carInfo = carInfoDao.selectCarIfoById(carId);
            forSelect.setValue(carInfo.getId());
            forSelect.setLabel(carInfo.getCarNumber());
            forSelects.add(forSelect);
        }
        return forSelects;
    }

    @Override
    public List<ForSelect> getCarsInCarInfo() {
        List<CarInfo> carInfos = carInfoDao.selectAllCarInfosIdAndCarNumber();
        List<ForSelect> forSelects = new ArrayList<>();
        for (CarInfo carInfo : carInfos) {
            ForSelect forSelect = new ForSelect();
            ParkingRecord parkingRecord = parkingRecordDao.selectParkingRecordByCarIdAndNoOutTime(carInfo.getId());
            if (parkingRecord != null) {
                forSelect.setDisabled(true);
            }
            forSelect.setValue(carInfo.getId());
            forSelect.setLabel(carInfo.getCarNumber());
            forSelects.add(forSelect);
        }
        return forSelects;
    }

    @Override
    public int addRecord(int carId) {
        CarInfo carInfo = carInfoDao.selectCarIfoById(carId);
        if (carInfo.getOwnersInfo() == null) {
            return 0;
        }else if(parkingRecordDao.selectParkingRecordByCarIdAndNoOutTime(carId)!=null){
            return 1;
        } else {
            ParkingRecord parkingRecord = new ParkingRecord();
            parkingRecord.setRecordNumber(UUID.randomUUID().toString().replace("-", ""));
            parkingRecord.setCarInfo(carInfo);
            parkingRecord.setOwnersInfo(carInfo.getOwnersInfo());
            parkingRecord.setInTime(new Date());
            parkingRecordDao.insertParkingRecordBySelf(parkingRecord);
            return 2;
        }
    }

    @Override
    public void changeCarOutRecord(int id) {
        ParkingRecord parkingRecord = parkingRecordDao.selectParkingRecordById(id);
        Date outTime=new Date();
        Long costTime=outTime.getTime()-parkingRecord.getInTime().getTime();
        System.out.println(costTime);
        double h= (double) (costTime/(1000*60*60.0));
        BigDecimal cost=new BigDecimal(h);
        if(h<=2){
            cost=cost.multiply(new BigDecimal(2));
        }else {
            cost=cost.subtract(new BigDecimal(2)).multiply(new BigDecimal(1)).add(new BigDecimal(4));
        }
        parkingRecordDao.updateOutTimeAndCost(id,outTime,cost);
    }
}

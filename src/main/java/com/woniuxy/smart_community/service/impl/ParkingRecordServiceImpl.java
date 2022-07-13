package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.dao.CarInfoDao;
import com.woniuxy.smart_community.dao.ParkingRecordDao;
import com.woniuxy.smart_community.entity.CarInfo;
import com.woniuxy.smart_community.entity.ParkingRecord;
import com.woniuxy.smart_community.service.ParkingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingRecordServiceImpl implements ParkingRecordService {
    @Autowired
    ParkingRecordDao parkingRecordDao;
    @Autowired
    CarInfoDao carInfoDao;
    @Override
    public PageInfo<ParkingRecord> getParkingRecordsToPage(int pageIndex, int pageSize, ParkingRecord queryParkingRecord) {
        PageHelper.startPage(pageIndex, pageSize);
        String carNumber=queryParkingRecord.getCarInfo().getCarNumber();
        if(carNumber!=null && !carNumber.equals("")){
            CarInfo carInfo=carInfoDao.selectCarIfoByCarNumber(carNumber);
            queryParkingRecord.setCarInfo(carInfo);
            System.out.println("CarInfo:"+carInfo);
        }

        List<ParkingRecord> parkingRecords=parkingRecordDao.selectParkingRecordToPage(queryParkingRecord);
        System.out.println(parkingRecords);
        PageInfo<ParkingRecord> pageInfo=new PageInfo<>(parkingRecords);
        int total=parkingRecordDao.selectCountToPage(queryParkingRecord);
        pageInfo.setTotal(total);
        return pageInfo;
    }
}

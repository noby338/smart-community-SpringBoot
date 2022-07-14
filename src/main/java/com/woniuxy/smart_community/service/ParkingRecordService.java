package com.woniuxy.smart_community.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.ForSelect;
import com.woniuxy.smart_community.entity.ParkingRecord;

import java.util.List;

public interface ParkingRecordService {
    PageInfo<ParkingRecord> getParkingRecordsToPage(int pageIndex, int pageSize, ParkingRecord queryParkingRecord);

    List<ForSelect> getCarsInParkingRecord();

    List<ForSelect> getCarsInCarInfo();

    int addRecord(int carId);

    void changeCarOutRecord(int id);
}

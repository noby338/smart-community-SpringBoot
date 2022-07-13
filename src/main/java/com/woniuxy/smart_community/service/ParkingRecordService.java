package com.woniuxy.smart_community.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.ParkingRecord;

public interface ParkingRecordService {
    PageInfo<ParkingRecord> getParkingRecordsToPage(int pageIndex, int pageSize, ParkingRecord queryParkingRecord);
}

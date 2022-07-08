package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.ParkingRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/8 0:36
 */
@Mapper
public interface ParkingRecordDao {
    List<ParkingRecord> selectParkingRecord(@Param("parkingRecord") ParkingRecord parkingRecord);

    int selectParkingRecordNums(@Param("parkingRecord") ParkingRecord parkingRecord);

    void insertParingRecordInto(@Param("parkingRecord") ParkingRecord parkingRecord);

    void updateParkingRecordOut(@Param("parkingRecord") ParkingRecord parkingRecord);

}

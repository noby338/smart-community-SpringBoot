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
    //文总使用
    int selectCountNotOut();

    List<ParkingRecord> selectParkingRecordToPage(@Param("parkingRecord")ParkingRecord queryParkingRecord);
    int selectCountToPage(@Param("parkingRecord")ParkingRecord queryParkingRecord);

}

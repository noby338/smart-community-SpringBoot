package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.CarInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarInfoDao {
//    查询
    List<CarInfo> selectAllCarInfos();
    CarInfo selectCarInfoByCarid(int carId);
    CarInfo selectCarInfoByCarno(String carNo);

//    添加

    /**
     * 添加车辆信息，默认添加carstate=1
     * @param carInfo
     */
    void insertCarInfo(@Param("carInfo") CarInfo carInfo);

//    修改
    //void updateCarInfo(@Param("carInfo") CarInfo carInfo);

    /**
     * 基本功能改变车辆状态carstate
     * @param carState
     * @param carId
     */
    void updateCarInfoState(@Param("carState") int carState,@Param("carId") int carId);

//    删除

    /**
     * 管理功能，真删除信息
     * @param carId
     */
    void deleteCarInfoByCarid(int carId);
}

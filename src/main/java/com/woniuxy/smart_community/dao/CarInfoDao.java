package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.CarInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarInfoDao {
//    查询
    List<CarInfo> selectAllCarInfos();
    CarInfo selectCarInfoByCarid(int carid);
    CarInfo selectCarInfoByCarno(String carno);

//    添加
    void insertCarInfo(@Param("carInfo") CarInfo carInfo);

//    修改
    //void updateCarInfo(@Param("carInfo") CarInfo carInfo);
    void updateCarInfoState(@Param("carstate") int carstate,@Param("carid") int carid);

//    删除
    void deleteCarInfoByCarid(int carid);
}

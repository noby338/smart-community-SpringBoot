package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.CarInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarInfoDao {
    //查询分页显示的车辆信息
    List<CarInfo> selectAllCarInfos();
    int selectCountCarInfo();

    void updateImgByCarNumber(@Param("carNumber") String carNumber,
                              @Param("imgAddress") String imgAddress);
}

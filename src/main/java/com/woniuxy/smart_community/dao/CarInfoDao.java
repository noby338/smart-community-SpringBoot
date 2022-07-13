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
    //通过一个车位id找到一个车辆：1对1
    CarInfo selectCarByParkId(Integer id);

    void updateCarInfoByIdAndParkId(@Param("carId")int carId,
                                    @Param("parkId")int parkId);

    void updateCarInfoByIdAndOwnerId(@Param("carId")int carId,
                                     @Param("ownerId")int ownerId);
}

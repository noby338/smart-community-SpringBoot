package com.woniuxy.smart_community.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.CarInfo;
import com.woniuxy.smart_community.entity.ForSelect;

import java.util.List;

/**
 * @Description 车辆信息管理
 * @Author LittleCode
 * @Date 2022/7/6 17:56
 */
public interface CarInfoService {
    PageInfo<CarInfo> getAllCarInfo(int pageIndex, int pageSize);

    List<ForSelect> getALLParkingInfoIdAndParkNumber(int id);

    void addImgAddress(String carNumber, String imgAddress);

    List<ForSelect> getAllCarOwnersIdAndName(int id);
}

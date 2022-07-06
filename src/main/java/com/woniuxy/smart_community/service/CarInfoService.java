package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.CarInfo;

import java.util.List;

/**
 * @Description 车辆信息管理
 * @Author LittleCode
 * @Date 2022/7/6 17:56
 */
public interface CarInfoService {
    List<CarInfo> getAllCarInfo();
}

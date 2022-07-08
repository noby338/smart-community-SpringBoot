package com.woniuxy.smart_community.service.impl;

import com.woniuxy.smart_community.dao.CarInfoDao;
import com.woniuxy.smart_community.entity.CarInfo;
import com.woniuxy.smart_community.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/6 17:57
 */
@Service
public class CarInfoServiceImpl implements CarInfoService {
    @Autowired
    CarInfoDao carInfoDao;

    @Override
    public List<CarInfo> getAllCarInfo() {
        List<CarInfo> carInfos=carInfoDao.selectAllCarInfos();
        return carInfos;
    }
}

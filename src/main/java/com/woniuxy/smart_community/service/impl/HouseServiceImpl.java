package com.woniuxy.smart_community.service.impl;

import com.woniuxy.smart_community.dao.HouseBuildingDao;
import com.woniuxy.smart_community.dao.HouseDao;
import com.woniuxy.smart_community.dao.HouseFloorDao;
import com.woniuxy.smart_community.dao.HouseUnitDao;
import com.woniuxy.smart_community.entity.*;
import com.woniuxy.smart_community.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author :  Fiver_Hu
 * @Date : 2022/7/6 11:08 星期三
 * @Project_Name -> smart-community
 * @Package_Name -> com.woniuxy.smart_community.service.impl
 * @ClassName -> HouseServiceImpl
 * @Version 1.0
 **/
@SuppressWarnings("ALL")
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    HouseBuildingDao houseBuildingDao;
    @Autowired
    HouseUnitDao houseUnitDao;
    @Autowired
    HouseFloorDao houseFloorDao;
    @Autowired
    HouseDao houseDao;
    @Autowired
    HouseBuilding houseBuilding;
    @Autowired
    HouseUnit houseUnit;
    @Autowired
    HouseFloor houseFloor;
    @Autowired
    House house;


    @Override
    public ResponseEntity updateHouse(HouseInfo houseInfo) {
        return null;
    }

    @Override
    public ResponseEntity selectHouse(HouseInfo houseInfo, int pageNum, int pageSize) {
        return null;
    }
}

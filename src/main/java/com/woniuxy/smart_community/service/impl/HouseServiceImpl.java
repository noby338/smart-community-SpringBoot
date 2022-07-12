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



    @Override
    public ResponseEntity selectHouse(HouseInfo houseInfo, int pageNum, int pageSize) {

        ResponseEntity<List<House>> responseEntityHouse = null;
        ResponseEntity<List<HouseFloor>> responseEntityFloor = null;
        ResponseEntity<List<HouseBuilding>> responseEntityBuilding = null;
        if (houseInfo.getFloorId() != null) {
            List<House> houses = houseDao.selectHouseByFloorId(houseInfo.getFloorId());
            responseEntityHouse = new ResponseEntity<List<House>>(200, "获取成功！", houses);
            return responseEntityHouse;
        }
        if(houseInfo.getUnitId() != null){
            List<HouseFloor> floors = houseDao.selectHouseByUnitId(houseInfo.getUnitId());
            responseEntityFloor = new ResponseEntity<List<HouseFloor>>(200, "获取成功！", floors);
            return responseEntityFloor;
        }
        if(houseInfo.getBuildingId() != null){
            List<HouseBuilding> buildings = houseDao.selectHouseByBuildingId(houseInfo.getBuildingId());
            responseEntityBuilding = new ResponseEntity<List<HouseBuilding>>(200, "获取成功！", buildings);
            return responseEntityBuilding;
        }
        return responseEntityHouse = new ResponseEntity<>(200,"获取失败！",null);

    }

    @Override
    public ResponseEntity updateHouse(HouseInfo houseInfo) {
        return null;
    }
}

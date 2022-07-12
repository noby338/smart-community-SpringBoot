package com.woniuxy.smart_community.service.impl;

import com.woniuxy.smart_community.dao.HouseBuildingDao;
import com.woniuxy.smart_community.dao.HouseDao;
import com.woniuxy.smart_community.dao.HouseFloorDao;
import com.woniuxy.smart_community.dao.HouseUnitDao;
import com.woniuxy.smart_community.entity.*;
import com.woniuxy.smart_community.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public ArrayList<Integer> selectHouseById(HouseInfo houseInfo) {
        ArrayList<Integer> houseId = new ArrayList<>();

        if (houseInfo.getBuildingId() == null && houseInfo.getUnitId() == null && houseInfo.getFloorId() == null) {
            List<HouseBuilding> buildings = houseDao.selectHouseByBuildingId(houseInfo);
            for (HouseBuilding houseBuilding : buildings) {
                for (HouseUnit houseUnit : houseBuilding.getHouseUnitList()) {
                    for (HouseFloor houseFloor : houseUnit.getHouseFloorList()) {
                        for (House house : houseFloor.getHouseList()) {
                            houseId.add(house.getId());
                        }
                    }
                }
            }
            return houseId;
        }else {
            if(houseInfo.getBuildingId() != null){
                List<HouseBuilding> buildings = houseDao.selectHouseByBuildingId(houseInfo);
                for (HouseBuilding houseBuilding : buildings) {
                    for (HouseUnit houseUnit : houseBuilding.getHouseUnitList()) {
                        for (HouseFloor houseFloor : houseUnit.getHouseFloorList()) {
                            for (House house : houseFloor.getHouseList()) {
                                houseId.add(house.getId());
                            }
                        }
                    }
                }
                return houseId;
            }else if(houseInfo.getUnitId() != null){
                List<HouseUnit> houseUnits = houseDao.selectHouseByUnitId(houseInfo);
                for (HouseUnit houseUnit : houseUnits) {
                    for (HouseFloor houseFloor : houseUnit.getHouseFloorList()) {
                        for (House house : houseFloor.getHouseList()) {
                            houseId.add(house.getId());
                        }
                    }
                }
                return houseId;
            }else{
                List<HouseFloor> houseFloors = houseDao.selectHouseByFloorId(houseInfo);
                for (HouseFloor houseFloor : houseFloors) {
                    for (House house : houseFloor.getHouseList()) {
                        houseId.add(house.getId());
                    }
                }
                return houseId;
            }
        }
    }

    @Override
    public ResponseEntity selectHouse(HouseInfo houseInfo, int pageNum, int pageSize) {

        ResponseEntity<List<HouseFloor>> responseEntityHouse = null;
        ResponseEntity<List<HouseUnit>> responseEntityFloor = null;
        ResponseEntity<List<HouseBuilding>> responseEntityBuilding = null;
        if (houseInfo.getFloorId() != null) {
            List<HouseFloor> houseFloors = houseDao.selectHouseByFloorId(houseInfo);
            responseEntityHouse = new ResponseEntity<List<HouseFloor>>(200, "获取成功！", houseFloors);
            return responseEntityHouse;
        }
        if(houseInfo.getUnitId() != null){
            List<HouseUnit> houseUnits = houseDao.selectHouseByUnitId(houseInfo);
            responseEntityFloor = new ResponseEntity<List<HouseUnit>>(200, "获取成功！", houseUnits);
            return responseEntityFloor;
        }
        if(houseInfo.getBuildingId() != null){
            List<HouseBuilding> buildings = houseDao.selectHouseByBuildingId(houseInfo);
            responseEntityBuilding = new ResponseEntity<List<HouseBuilding>>(200, "获取成功！", buildings);
            return responseEntityBuilding;
        }
        return responseEntityHouse = new ResponseEntity<>(200,"获取失败！",null);

    }

    @Override
    public ResponseEntity selectAllHouse(HouseInfo houseInfo) {
        ResponseEntity<List<HouseBuilding>> responseEntityBuilding = null;
        List<HouseBuilding> buildings = houseDao.selectHouseByBuildingId(null);
        return responseEntityBuilding = new ResponseEntity<List<HouseBuilding>>(200,"获取失败！",buildings);
    }

    @Override
    public ResponseEntity updateHouse(HouseInfo houseInfo) {
        return null;
    }
}

package com.woniuxy.smart_community.service.impl;

import com.woniuxy.smart_community.dao.*;
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
    HouseHoldDao houseHoldDao;
    @Autowired
    HouseDao houseDao;



    @Override
    public ArrayList<Integer> selectHouseById(HouseInfo houseInfo) {
        ArrayList<Integer> houseId = new ArrayList<>();

        if (houseInfo.getBuildingId() == null && houseInfo.getUnitId() == null && houseInfo.getFloorId() == null && houseInfo.getHouseId() == null) {
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
        } else {
            if (houseInfo.getBuildingId() != null) {
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
            } else if (houseInfo.getUnitId() != null) {
                List<HouseUnit> houseUnits = houseDao.selectHouseByUnitId(houseInfo);
                for (HouseUnit houseUnit : houseUnits) {
                    for (HouseFloor houseFloor : houseUnit.getHouseFloorList()) {
                        for (House house : houseFloor.getHouseList()) {
                            houseId.add(house.getId());
                        }
                    }
                }
                return houseId;
            } else if (houseInfo.getFloorId() != null) {
                List<HouseFloor> houseFloors = houseDao.selectHouseByFloorId(houseInfo);
                for (HouseFloor houseFloor : houseFloors) {
                    for (House house : houseFloor.getHouseList()) {
                        houseId.add(house.getId());
                    }
                }
                return houseId;
            } else {
                houseId.add(houseInfo.getHouseId());
                return houseId;
            }
        }
    }

    @Override
    public ArrayList<House> selectHouse(HouseInfo houseInfo) {
        HouseHold houseHold = new HouseHold();
        HouseBuilding houseBuilding2 = new HouseBuilding();
        HouseUnit houseUnit2 = new HouseUnit();
        HouseFloor houseFloor2 = new HouseFloor();

        HouseInfo houseInfo1 = new HouseInfo();
        ArrayList<House> houseArrayList = new ArrayList<House>();
        if (houseInfo.getFloorId() != null) {
            List<HouseFloor> houseFloors = houseDao.selectHouseByFloorId(houseInfo);
            for(HouseFloor houseFloor : houseFloors){
                houseInfo1.setUnitId(houseFloor.getUnitId());
            }
            List<HouseBuilding> buildings = houseDao.selectHouseByBuildingId(houseInfo1);
            for(HouseBuilding houseBuilding: buildings){
                houseInfo1.setBuildingId(houseBuilding.getId());
            }
            for(HouseFloor houseFloor: houseFloors){
                for(House house : houseFloor.getHouseList()){
                    //添加人员
                    houseHold.setHouseId(house.getId());
                    List<HouseHold> houseHolds = houseHoldDao.selectHouseHoldByHouseHoldInfo(houseHold);
                    house.setHouseHoldList(houseHolds);

                    //添加楼栋名
                    house.setBuildingId(houseInfo1.getBuildingId());
                    houseBuilding2.setId(houseInfo1.getBuildingId());
                    HouseBuilding houseBuilding1 = houseBuildingDao.selectHouseBuilding(houseBuilding2);
                    house.setBuildingName(houseBuilding1.getName());

                    //添加单元名
                    house.setUnitId(houseInfo1.getUnitId());
                    houseUnit2.setId(houseInfo1.getUnitId());
                    HouseUnit houseUnit1 = houseUnitDao.selectHouseUnit(houseUnit2);
                    house.setNuitName(houseUnit1.getName());

                    //添加楼栋名
                    houseFloor2.setId(houseInfo1.getFloorId());
                    HouseFloor houseFloor1 = houseFloorDao.selectHouseFloor(houseFloor2);
                    house.setFloorName(houseFloor1.getName());
                    houseArrayList.add(house);
                }
            }
            return houseArrayList;
        }
        if(houseInfo.getUnitId() != null){
            houseInfo1.setUnitId(houseInfo.getUnitId());
            List<HouseUnit> houseUnits = houseDao.selectHouseByUnitId(houseInfo);
            for(HouseUnit houseUnit : houseUnits){
                houseInfo1.setBuildingId(houseUnit.getBuildingId());
                for(HouseFloor houseFloor : houseUnit.getHouseFloorList()){
                    for(House house : houseFloor.getHouseList()){
                        //添加人员
                        houseHold.setHouseId(house.getId());
                        List<HouseHold> houseHolds = houseHoldDao.selectHouseHoldByHouseHoldInfo(houseHold);
                        house.setHouseHoldList(houseHolds);

                        //添加楼栋名
                        house.setBuildingId(houseInfo1.getBuildingId());
                        houseBuilding2.setId(houseInfo1.getBuildingId());
                        HouseBuilding houseBuilding1 = houseBuildingDao.selectHouseBuilding(houseBuilding2);
                        house.setBuildingName(houseBuilding1.getName());

                        //添加单元名
                        house.setUnitId(houseInfo1.getUnitId());
                        houseUnit2.setId(houseInfo1.getUnitId());
                        HouseUnit houseUnit1 = houseUnitDao.selectHouseUnit(houseUnit2);
                        house.setNuitName(houseUnit1.getName());

                        //添加楼栋名
                        houseFloor2.setId(houseInfo1.getFloorId());
                        HouseFloor houseFloor1 = houseFloorDao.selectHouseFloor(houseFloor2);
                        house.setFloorName(houseFloor1.getName());
                        houseArrayList.add(house);
                    }
                }
            }
            return houseArrayList;
        }

            List<HouseBuilding> buildings = houseDao.selectHouseByBuildingId(houseInfo);
            for(HouseBuilding houseBuilding: buildings){
                houseInfo1.setBuildingId(houseBuilding.getId());
                for(HouseUnit houseUnit: houseBuilding.getHouseUnitList()){
                    houseInfo1.setUnitId(houseUnit.getId());
                    for(HouseFloor houseFloor: houseUnit.getHouseFloorList()){
                        houseInfo1.setFloorId(houseFloor.getId());
                        for(House house: houseFloor.getHouseList()){
                            //添加人员
                            houseHold.setHouseId(house.getId());
                            List<HouseHold> houseHolds = houseHoldDao.selectHouseHoldByHouseHoldInfo(houseHold);
                            house.setHouseHoldList(houseHolds);

                            //添加楼栋名
                            house.setBuildingId(houseInfo1.getBuildingId());
                            houseBuilding2.setId(houseInfo1.getBuildingId());
                            HouseBuilding houseBuilding1 = houseBuildingDao.selectHouseBuilding(houseBuilding2);
                            house.setBuildingName(houseBuilding1.getName());

                            //添加单元名
                            house.setUnitId(houseInfo1.getUnitId());
                            houseUnit2.setId(houseInfo1.getUnitId());
                            HouseUnit houseUnit1 = houseUnitDao.selectHouseUnit(houseUnit2);
                            house.setNuitName(houseUnit1.getName());

                            //添加楼栋名
                            houseFloor2.setId(houseInfo1.getFloorId());
                            HouseFloor houseFloor1 = houseFloorDao.selectHouseFloor(houseFloor2);
                            house.setFloorName(houseFloor1.getName());
                            houseArrayList.add(house);
                        }
                    }
                }
            }
        return houseArrayList;
    }

    @Override
    public ResponseEntity selectAllHouse(HouseInfo houseInfo) {
        ResponseEntity<List<HouseBuilding>> responseEntityBuilding = null;
        List<HouseBuilding> buildings = houseDao.selectHouseByBuildingId(null);
        return responseEntityBuilding = new ResponseEntity<List<HouseBuilding>>(200, "获取失败！", buildings);
    }

    /**
     * 获取小区楼栋信息
     *
     * @return
     */
    @Override
    public ResponseEntity<List<HouseBuilding>> selectAllHouseByBuilding() {
        ResponseEntity<List<HouseBuilding>> responseEntityBuilding = null;
        List<HouseBuilding> houseBuildings = houseDao.selectHouseByBuildingId();
        return responseEntityBuilding = new ResponseEntity<>(200, "获取成功", houseBuildings);
    }

    @Override
    public ResponseEntity updateHouse(HouseInfo houseInfo) {
        return null;
    }

    @Override
    public List<Cascade> selectAllHouseBuilding() {
        List<HouseBuilding> houseBuildingList = houseDao.selectAllHouseBuilding();
        List<Cascade> cascadeArrayList = new ArrayList<>();


        for (HouseBuilding houseBuilding : houseBuildingList) {
            Cascade cascade = new Cascade();
            cascade.setValue(houseBuilding.getId() + "");
            cascade.setLabel(houseBuilding.getName());
            List<Cascade> cascadeArrayList1 = new ArrayList<>();
            List<HouseUnit> houseUnitList = houseBuilding.getHouseUnitList();

            for (HouseUnit houseUnit : houseUnitList) {
                Cascade cascade1 = new Cascade();
                cascade1.setValue(houseUnit.getId() + "");
                cascade1.setLabel(houseUnit.getName());
                List<Cascade> cascadeArrayList2 = new ArrayList<>();
                List<HouseFloor> houseFloorList = houseUnit.getHouseFloorList();

                for (HouseFloor houseFloor : houseFloorList) {
                    Cascade cascade2 = new Cascade();
                    cascade2.setValue(houseFloor.getId() + "");
                    cascade2.setLabel(houseFloor.getName());
                    List<Cascade> cascadeArrayList3 = new ArrayList<>();
                    List<House> houseList = houseFloor.getHouseList();

                    for (House house : houseList) {
                        Cascade cascade3 = new Cascade();
                        cascade3.setValue(house.getId() + "");
                        cascade3.setLabel(house.getHouseNum());
                        cascadeArrayList3.add(cascade3);
                    }

                    cascade2.setChildren(cascadeArrayList3);
                    cascadeArrayList2.add(cascade2);
                }

                cascade1.setChildren(cascadeArrayList2);
                cascadeArrayList1.add(cascade1);
            }

            cascade.setChildren(cascadeArrayList1);
            cascadeArrayList.add(cascade);
        }
        return cascadeArrayList;
//        return null;
    }
}

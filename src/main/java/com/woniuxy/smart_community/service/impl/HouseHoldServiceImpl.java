package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.dao.HouseDao;
import com.woniuxy.smart_community.dao.HouseHoldDao;
import com.woniuxy.smart_community.entity.*;
import com.woniuxy.smart_community.service.HouseHoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  Fiver_Hu
 * @Date : 2022/7/11 16:45 星期一
 * @Project_Name -> smart-community
 * @Package_Name -> com.woniuxy.smart_community.service.impl
 * @ClassName -> HouseHoldServiceImpl
 * @Version 1.0
 **/
@Service
public class HouseHoldServiceImpl implements HouseHoldService {

    @Autowired
    HouseDao houseDao;
    @Autowired
    HouseHoldDao houseHoldDao;

    @Override
    public PageInfo<HouseHold> selectHouseHoldByHouseHoldInfo(HouseHold houseHold ,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<HouseHold> houseHolds = houseHoldDao.selectHouseHoldByHouseHoldInfo(houseHold);
        return new PageInfo<>(houseHolds);
    }

    @Override
    public int insert(HouseHold houseHold) {
        return houseHoldDao.insert(houseHold);
    }

    @Override
    public int update(HouseHold houseHold) {
        return houseHoldDao.update(houseHold);
    }

    @Override
    public int deleteById(Integer id) {
        return houseHoldDao.deleteById(id);
    }

    @Override
    public int deleteByHouseId(Integer id) {
        return houseHoldDao.deleteByHouseId(id);
    }

    @Override
    public int countByHouseHouseInfo(HouseHold houseHold) {
        return houseHoldDao.countByHouseHouseInfo(houseHold);
    }


    @Override
    public List<Integer> selectHouseIdListByHouseInfo(HouseInfo houseInfo) {
        List<Integer> houseIdList = new ArrayList<>();

        List<HouseBuilding> buildings = houseDao.selectHouseByBuildingId(houseInfo);
        for(HouseBuilding houseBuilding : buildings){
            for(HouseUnit houseUnit: houseBuilding.getHouseUnitList()){
                for(HouseFloor houseFloor: houseUnit.getHouseFloorList()){
                    for(House house: houseFloor.getHouseList()){
                        houseIdList.add(house.getId());
                    }
                }
            }
        }
//        if(houseParam.getBuildingId() != null){
//            HouseBuilding houseBuilding = houseDao.selectHouseByBuildingId(houseParam.getBuildingId());
//            for(HouseUnit houseUnit: houseBuilding.getHouseUnitList()){
//                for(HouseFloor houseFloor: houseUnit.getHouseFloorList()){
//                    for(House house: houseFloor.getHouseList()){
//                        houseIdList.add(house.getId());
//                    }
//                }
//            }
//        }else {
//            if(houseParam.getUtilId() != null){
//                HouseUnit houseUnit = houseDao.selectHouseByUnitId(houseParam.getUtilId());
//                for(HouseFloor houseFloor: houseUnit.getHouseFloorList()){
//                    for(House house: houseFloor.getHouseList()){
//                        houseIdList.add(house.getId());
//                    }
//                }
//            }else {
//                if(houseParam.getFloorId() != null){
//                    HouseFloor houseFloor = houseDao.selectHouseByFloorId(houseParam.getFloorId());
//                    for(House house: houseFloor.getHouseList()){
//                        houseIdList.add(house.getId());
//                    }
//                }
//            }
//        }
        return houseIdList;
    }
}

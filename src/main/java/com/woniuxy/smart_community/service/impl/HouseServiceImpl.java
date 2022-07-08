package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.dao.HouseDao;
import com.woniuxy.smart_community.entity.House;
import com.woniuxy.smart_community.entity.ResponseEntity;
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
    HouseDao houseDao;

    @Override
    public ResponseEntity insertHouse(House house) {
        int isadd = houseDao.insertHouse(house);
        if(isadd == 1){
            return new ResponseEntity(200,"添加成功！",isadd);
        }else {
            return new ResponseEntity(401, "添加失败！", null);
        }
    }

    @Override
    public ResponseEntity deleteHouseById(Integer id) {
        int isdelete = houseDao.deleteHouseById(id);
        if(isdelete == 1){
            return new ResponseEntity(200,"删除成功！",null);
        }else {
            return new ResponseEntity(401, "删除失败！", null);
        }
    }

    @Override
    public ResponseEntity updateHouse(House house) {
        int isupdate = houseDao.updateHouse(house);
        if(isupdate == 1){
            return new ResponseEntity(200,"更新成功！",null);
        }else {
            return new ResponseEntity(401, "更新失败！", null);
        }
    }

    @Override
    public ResponseEntity selectHouseByHouseInfo(House house, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<House> houses = houseDao.selectHouseByHouseInfo(house);
        PageInfo<House> pageInfo = new PageInfo<>(houses);
        if(houses.size()>0){
            return new ResponseEntity(200,"获取成功！",pageInfo);
        }else {
            return new ResponseEntity(401,"获取失败！",pageInfo);
        }
    }

    @Override
    public ResponseEntity countHouses(House house) {
        Integer countHouses = houseDao.countHouses(house);
        if(countHouses == 1){
            return new ResponseEntity(200,"获取成功！",countHouses);
        }else {
            return new ResponseEntity(401, "删除失败！", null);
        }
    }
}

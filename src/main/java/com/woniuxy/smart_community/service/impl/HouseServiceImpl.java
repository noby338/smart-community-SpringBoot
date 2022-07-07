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
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    HouseDao houseDao;

    @Override
    public int insertHouse(House house) {
        int isadd = houseDao.insertHouse(house);
        return isadd;
    }

    @Override
    public int deleteHouseById(Integer id) {
        int isdelete = houseDao.deleteHouseById(id);
        return isdelete;
    }

    @Override
    public int updateHouse(House house) {
        int isupdate = houseDao.updateHouse(house);
        return isupdate;
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
    public Integer countHouses(House house) {
        Integer countHouses = houseDao.countHouses(house);
        return countHouses;
    }
}

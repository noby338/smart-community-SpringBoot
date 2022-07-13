package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.HouseUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author :  Fiver_Hu
 * @Date : 2022/7/9 15:13 星期六
 * @Project_Name -> smart-community
 * @Package_Name -> com.woniuxy.smart_community.dao
 * @ClassName -> HouseUnitDaoTest
 * @Version 1.0
 **/
@SpringBootTest
public class HouseUnitDaoTest {
    @Autowired
    HouseUnitDao houseUnitDao;

    @Test
    public void insertHouseUnitTest(){
        HouseUnit houseUnit = new HouseUnit();
        houseUnit.setName("测试");
        houseUnit.setBuildingId(23);
        houseUnitDao.insertHouseUnit(houseUnit);
    }

    @Test
    public void delectHouseUnitTest(){
        HouseUnit houseUnit = new HouseUnit();
        houseUnit.setId(102);
        houseUnitDao.delectHouseUnit(houseUnit);
    }

    @Test
    public void updateHouseUnitTest(){
        HouseUnit houseUnit = new HouseUnit();
        houseUnit.setId(104);
        houseUnit.setName("测试1");
        houseUnit.setBuildingId(20);
        houseUnitDao.updateHouseUnit(houseUnit);
    }

    @Test
    public void selectHouseUnitTest(){
        HouseUnit houseUnit = new HouseUnit();
        houseUnit.setBuildingId(20);
        houseUnitDao.selectHouseUnit(houseUnit);
    }
}

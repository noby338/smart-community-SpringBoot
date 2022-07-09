package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.House;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName -> HouseDaoTest
 * @Author Fiver_Hu
 * @Date 2022/7/5 16:43 星期二
 * @Version 1.0
 **/
@SuppressWarnings("ALL")
@SpringBootTest
public class HouseDaoTest {
    @Autowired
    HouseDao houseDao;
    @Autowired
    HouseUnitDao houseUnitDao;
    @Autowired
    HouseFloorDao houseFloorDao;
    @Autowired
    HouseHoldDao houseHoldDao;

    @Test
    public void insertHouse(){
        House house = new House();
        house.setFloorId(2402);
        house.setHouseNum("01020304");
        house.setHousePeopleNums(5);
        houseDao.insertHouse(house);
    }

    @Test
    public void deleteHouse(){
        House house = new House();
        house.setId(7201);
        houseDao.deleteHouse(house);

    }

    @Test
    public void updateHouse(){
        House house = new House();
        house.setHousePeopleNums(55);
        house.setFloorId(2400);
        house.setId(7202);
        houseDao.updateHouse(house);

    }

    @Test
    public void selectHouse(){
        House house = new House();
        house.setFloorId(2400);
        houseDao.selectHouse(house);
    }
}

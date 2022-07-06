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
@SpringBootTest
public class HouseDaoTest {
    @Autowired
    HouseDao houseDao;

    @Test
    public void insertHouse(){
        House house = new House();
        for(int i = 0 ;i<50;i++){
            house.setId(i);
            house.setBuilding(i%2);
            house.setUnit(i%3);
            house.setFloor(i%24);
            house.setHouseNum("i+123");
            house.setHousePeopleNums(i%8);
            house.setHouseState(i%2);
            houseDao.insertHouse(house);
        }
    }

    @Test
    public  void  selectHouseByHouseInfoTest(){
        House house = new House();
        house.setFloor(1);
        System.out.println(houseDao.selectHouseByHouseInfo(house));
    }

    @Test
    public void updateHouse(){
        House house = new House();
        for(int i = 0 ;i<100;i++){
            house.setId(i);
            house.setBuilding(i%2);
            house.setUnit(i%2);
            house.setFloor(i%2);
            house.setHouseNum("12131415");
            house.setHousePeopleNums(i%2);
            house.setHouseState(i%2);
            houseDao.updateHouse(house);
        }
    }

    @Test
    public void deleteByIdTest(){
        houseDao.deleteHouseById(1);
    }

    @Test
    public void count(){
        House house = new House();
        house.setFloor(2);
        System.out.println(houseDao.countHouses(house));
    }
}

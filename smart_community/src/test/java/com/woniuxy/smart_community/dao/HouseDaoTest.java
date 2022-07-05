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
        for(int i = 0 ;i<100;i++){
            house.setId(i);
            house.setBuilding(i/2);
            house.setUnit(i/3);
            house.setFloor(i/6);
            house.setHouse_num("123456789");
            house.setHouse_people_nums(i/8);
            house.setHouse_state(i%2);
            int nums = houseDao.insert(house);
        }
    }
    @Test
    public void updateHouse(){
        House house = new House();
        for(int i = 0 ;i<100;i++){
            house.setId(i);
            house.setBuilding(i%4);
            house.setUnit(i%3);
            house.setFloor(i%6);
            house.setHouse_num("");
            house.setHouse_people_nums(i/8);
            house.setHouse_state(i%2);
            int nums = houseDao.update(house);
        }
    }
}

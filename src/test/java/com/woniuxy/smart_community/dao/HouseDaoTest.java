package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.House;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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
//        House house = new House();
//        for(int i = 0 ;i<50;i++){
//            house.setBuilding(i%2);
//            house.setUnit(i%3);
//            house.setFloor(i%24);
//            house.setHouseNum("i+123");
//            house.setHousePeopleNums(i%8);
//            house.setHouseState(i%2);
//            houseDao.insertHouse(house);
//        }

        House house = new House();
        house.setId(1);
        int[] state = {2,2,3,1,1,1,1,1,1,1,1,1,1,1,1,1};//状态数组
        for (int i = 1; i <= 5; i++) {//楼栋
            for (int i1 = 1; i1 <= 4; i1++) {//单元
                for (int i2 = 1; i2 <= 10; i2++) {//楼层
                    for (int i3 = 1; i3 <= 3; i3++) {//门号
                        house.setBuilding(i);
                        house.setUnit(i1);
                        house.setFloor(i2);
                        house.setHouseNum(String.format("%02d%02d%02d%02d",i,i1,i2,i3));
                        house.setHousePeopleNums((int)(Math.random()*(6-2)+2));//随机注入[2,6)个家庭成员
                        house.setHouseState(state[(int)(Math.random()*(state.length))]);
                        houseDao.insertHouse(house);
                        house.setId(null);
                    }
                }

            }

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

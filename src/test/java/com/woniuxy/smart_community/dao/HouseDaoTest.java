package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.House;
import com.woniuxy.smart_community.entity.HouseFloor;
import com.woniuxy.smart_community.entity.HouseHold;
import com.woniuxy.smart_community.entity.HouseUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

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
        for (int i = 1; i <= 2400; i++) {//楼层id
            for (int i2 = 1; i2 <= 3; i2++) {//门牌号
                house.setFloorId(i);

                HouseFloor houseFloor = houseFloorDao.selectById(i);
                String floorNum = houseFloor.getName().substring(0,houseFloor.getName().length()-1);
                Integer unitId = houseFloor.getUnitId();

                HouseUnit houseUnit = houseUnitDao.selectById(unitId);
                String unitNum = houseUnit.getName().substring(0, houseUnit.getName().length() - 2);

                Integer buildingId = houseUnit.getBuildingId();

                house.setHouseNum(String.format("%02d%02d%02d%02d",buildingId ,Integer.parseInt(unitNum),Integer.parseInt(floorNum), i2));
                houseDao.insertHouse(house);
            }
        }


    }


    @Test
    public void updateHouse(){
        House house = new House();
        HouseHold houseHold = new HouseHold();
        for(int i = 1 ;i<=1000;i++){
            house.setId(i);
            houseHold.setHouseId(i);
            int peoples = houseHoldDao.countByHouseHouseInfo(houseHold);
            if (peoples>0){
                house.setHousePeopleNums(peoples);
                house.setHouseState(new Random().nextInt(2) + 1);
            }else {
                house.setHousePeopleNums(peoples);
                if((i % 3) == 0){
                    house.setHouseState(3);
                }else if((i%3)==1){
                    house.setHouseState(4);
                }else {
                    house.setHouseState(5);
                }
            }
            houseDao.updateHouse(house);
        }
    }

    @Test
    public void deleteByIdTest(){
        houseDao.deleteHouseById(1);
    }

}

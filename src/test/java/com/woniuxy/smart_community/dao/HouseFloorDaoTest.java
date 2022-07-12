package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.HouseFloor;
import com.woniuxy.smart_community.entity.HouseUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description 测试类
 * @Author noby
 * @Date 2022/7/8 17:58
 */
@SpringBootTest
class HouseFloorDaoTest {
    @Autowired
    HouseFloorDao houseFloorDao;

    @Autowired
    HouseUnitDao houseUnitDao;
    /**
     * 插入数据到数据库
     */

    @Test
    public void insertUnit(){
        HouseUnit houseUnit = new HouseUnit();
        for(int i = 1; i <= 5 ;i++){
            houseUnit.setBuildingId(i);
            houseUnit.setName("一单元");
            houseUnitDao.insertHouseUnit(houseUnit);
        }
    }

    @Test
    void testInsert() {
        HouseFloor houseFloor = new HouseFloor();
        houseFloor.setId(2401);
        houseFloorDao.deleteHouseFloor(houseFloor);
    }

    @Test
    void updateHouseFloorTset() {
        HouseFloor houseFloor = new HouseFloor();
        houseFloor.setId(2402);
        houseFloor.setUnitId(99);
        houseFloor.setName("测试1");
        houseFloorDao.updateHouseFloor(houseFloor);
    }

    @Test
    void selectHouseFloorTset() {
        HouseFloor houseFloor = new HouseFloor();
        houseFloor.setUnitId(99);
        houseFloorDao.selectHouseFloor(houseFloor);
        for (int i = 1; i <= 24; i++) {//楼
            for (int j = 1; j <= 20; j++) {//单元id
                houseFloor.setName(i+"楼");
                houseFloor.setUnitId(j);
                houseFloorDao.insertHouseFloor(houseFloor);
            }
        }
    }
}
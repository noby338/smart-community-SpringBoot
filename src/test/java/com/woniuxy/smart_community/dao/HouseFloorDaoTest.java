package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.HouseFloor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description 测试类
 * @Author noby
 * @Date 2022/7/8 17:58
 */
@SpringBootTest
class HouseFloorDaoTest {
    @Autowired
    HouseFloorDao houseFloorDao;

    /**
     * 插入数据到数据库
     */
    @Test
    void insertHouseFloorTset() {
        HouseFloor houseFloor = new HouseFloor();
        houseFloor.setUnitId(100);
        houseFloor.setName("测试");
        houseFloorDao.insertHouseFloor(houseFloor);
    }

    @Test
    void deleteHouseFloorTset() {
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
    }
}
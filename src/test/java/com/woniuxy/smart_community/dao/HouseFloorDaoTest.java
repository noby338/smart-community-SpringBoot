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
    void testInsert() {
        HouseFloor houseFloor = new HouseFloor();
        for (int i = 1; i <= 24; i++) {//楼
            for (int i1 = 1; i1 <= 100; i1++) {//单元id
                houseFloor.setName(i+"楼");
                houseFloor.setUnitId(i1);
                houseFloorDao.insert(houseFloor);
            }
        }
    }
}
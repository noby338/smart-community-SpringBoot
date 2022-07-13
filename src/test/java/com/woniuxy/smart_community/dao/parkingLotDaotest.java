package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.ParkingLot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/9 20:58
 */
@SpringBootTest
public class parkingLotDaotest {
    @Autowired
    ParkingLotDao parkingLotDao;

    @Test
    void test01(){
        ParkingLot parkingLot = parkingLotDao.selectParkingLotById(1);
        System.out.println(parkingLot);
    }
}

package com.woniuxy.smart_community.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ParkingLotDaoTest {

    @Autowired
    ParkingLotDao parkingLotDao;

    @Test
    void test01(){
        System.out.println(parkingLotDao.selectAllParkingLot());
    }
    @Test
    void test02(){
        System.out.println(parkingLotDao.selectParkingLotById(1));
    }
    @Test
    void test03(){
        System.out.println(parkingLotDao.selectParkingLotByName("黄金"));
    }
    @Test
    void test04(){
        parkingLotDao.updateParkingLotState(0, 1);
    }



}

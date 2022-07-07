package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.ParkingInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @Author: LittleCode
 * @Date: 2022/7/6 14:09
 * @Description:
 */
@SpringBootTest
public class ParkingInfoDaoTest {
    @Autowired
    ParkingInfoDao parkingInfoDao;

    @Test
    void test01(){
        System.out.println(parkingInfoDao.selectAllParkingInfo());
    }
     @Test
    void test02(){
         ParkingInfo parkingInfo=new ParkingInfo();
         //parkingInfo.setParkId(1);
         parkingInfo.setParkNo("A");
         System.out.println(parkingInfoDao.selectCount(parkingInfo));
         System.out.println(parkingInfoDao.selectParkingInfoByParkingInfo(parkingInfo));
    }

    /**
     * 批量添加信息
     */
    @Test
    void test03(){
        for(int i=0;i<200;i++){
            ParkingInfo parkingInfo=new ParkingInfo();
            parkingInfo.setParkLotId(1);
            parkingInfo.setPTypeId(3);
            if(i<101){
                parkingInfo.setParkNo("A0"+i);
                parkingInfo.setParkArea(BigDecimal.valueOf(21.00));
            }else {
                parkingInfo.setParkNo("B0"+(i-100));
                parkingInfo.setParkArea(BigDecimal.valueOf(20));
            }

            parkingInfoDao.insertParkingInfo(parkingInfo);
            System.out.println("获取id:"+parkingInfo.getParkId());
        }

    }




}

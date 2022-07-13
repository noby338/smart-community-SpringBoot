package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.OwnersInfo;
import com.woniuxy.smart_community.entity.ParkingInfo;
import com.woniuxy.smart_community.entity.ParkingLot;
import com.woniuxy.smart_community.entity.ParkingType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/10 13:37
 */
@SpringBootTest
public class ParkingInfoDaoTest {
    @Autowired
    ParkingInfoDao parkingInfoDao;

    @Test
    void test01(){
        ParkingInfo parkingInfo=new ParkingInfo();
        List<ParkingInfo> parkingInfos = parkingInfoDao.selectParkingInfoByParkingInfo(parkingInfo);
        System.out.println(parkingInfos);
    }

    @Test
    void test02(){
        ParkingInfo parkingInfo = new ParkingInfo();
        BigDecimal areas=new BigDecimal(21.00);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(3);
        ParkingType parkingType = new ParkingType();
        parkingType.setId(3);
        for(int i=0;i<100;i++){
            parkingInfo.setId(i+1);
            parkingInfo.setParkingLot(parkingLot);
            parkingInfo.setParkingType(parkingType);
            parkingInfo.setParkArea(areas);
            parkingInfo.setParkNumber("A001"+i);
            parkingInfo.setOwnersInfo(new OwnersInfo(1,null,null,null,null));
            parkingInfoDao.insertParkingInfo(parkingInfo);
        }
    }
}

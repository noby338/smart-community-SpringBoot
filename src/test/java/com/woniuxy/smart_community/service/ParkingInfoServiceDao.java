package com.woniuxy.smart_community.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.ParkingInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/6 17:54
 */
@SpringBootTest
public class ParkingInfoServiceDao {
    @Autowired
    ParkingInfoService parkingInfoService;

    @Test
    void test01(){
        List<ParkingInfo> allParkingInfo = parkingInfoService.getAllParkingInfo();
        System.out.println(allParkingInfo);
    }
    @Test
    void test02(){
        ParkingInfo parkingInfo=new ParkingInfo();
        PageInfo<ParkingInfo> parkingInfoByPage = parkingInfoService.getParkingInfoByPage(1, 3, parkingInfo);
        System.out.println(parkingInfoByPage);
    }

}

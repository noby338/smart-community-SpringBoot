package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.CarInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/6 17:59
 */
@SpringBootTest
public class CarInfoServiceTest {
    @Autowired
    CarInfoService carInfoService;

    @Test
    void test01(){
        List<CarInfo> allCarInfo = carInfoService.getAllCarInfo();
        System.out.println(allCarInfo);
    }


}

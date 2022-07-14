package com.woniuxy.smart_community.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description 测试类
 * @Author noby
 * @Date 2022/7/14 13:32
 */
@SpringBootTest
class ElectricityServiceTest {
    @Autowired
    ElectricityService electricityService;

    @Test
    void testInsertElectricity() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, 4,1);
        electricityService.insertElectricity(calendar);
    }
    @Test
    void testUpdateLastMoneyAndState() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, 4,1);
        electricityService.updateElectricityByCalenderAndDosage(1,calendar,147.1119);
    }
}
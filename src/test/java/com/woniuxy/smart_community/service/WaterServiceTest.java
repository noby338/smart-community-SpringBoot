package com.woniuxy.smart_community.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description 测试类
 * @Author noby
 * @Date 2022/7/14 19:18
 */
@SpringBootTest
class WaterServiceTest {
    @Autowired
    WaterService waterService;

    @Test
    void testInsertWater() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, 4,1);
        waterService.insertWater(calendar);
    }

    @Test
    void testUpdateLastMoneyAndState() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, 4,1);
        waterService.updateWaterByCalenderAndDosage(1,calendar,147.1119);
    }
}
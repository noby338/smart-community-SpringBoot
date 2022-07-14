package com.woniuxy.smart_community.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description 测试类
 * @Author noby
 * @Date 2022/7/14 19:16
 */
@SpringBootTest
class GasServiceTest {
    @Autowired
    GasService gasService;

    @Test
    void testInsertGas() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, 4,1);
        gasService.insertGas(calendar);
    }

    @Test
    void testUpdateLastMoneyAndState() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, 4,1);
        gasService.updateGasByCalenderAndDosage(1,calendar,147.1119);
    }
}
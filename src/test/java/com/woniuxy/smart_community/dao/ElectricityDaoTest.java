package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.Electricity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description 电费表dao测试类
 * @Author noby
 * @Date 2022/7/6 14:47
 */
@SpringBootTest
class ElectricityDaoTest {
    @Autowired
    ElectricityDao electricityDao;
    @Test
    void selectByElectricity() {
        Electricity electricity = electricityDao.selectByElectricity(1);
        System.out.println("electricity = " + electricity);
    }
}
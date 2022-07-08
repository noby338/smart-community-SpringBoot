package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.Electricity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

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

    /**
     * 插入数据库数据
     */
    @Test
    void insertData() {
        Electricity electricity = new Electricity();
        int year = 2022;
        int month = 1;
        for (int i = 1; i <= 200; i++) {//房屋id
            BigDecimal nowMonthNums = new BigDecimal(0);//某房屋某月份的初始表用量
            for (int i1 = 0; i1 < 3; i1++) {//月份
                electricity.setHouseId(i);
                electricity.setMonth(String.format("%02d/%02d", year,month+i1));
                nowMonthNums = BigDecimal.valueOf((int) ((Math.random() * 500 * 10000) + 20 * 10000) / 10000.0).add(nowMonthNums);
                electricity.setNowMonthNums(nowMonthNums.doubleValue());
                electricityDao.insert(electricity);
            }
        }



//        BigDecimal nowMonthNums = new BigDecimal(0);
//        for (int i1 = 0; i1 < 5; i1++) {//月份
//            System.out.println("nowMonthNums = " + nowMonthNums);
//            nowMonthNums = BigDecimal.valueOf((int) ((Math.random() * 500 * 10000) + 20 * 10000) / 10000.0).add(nowMonthNums);
//
//        }
    }
}
package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.service.GradientPriceService;
import net.sf.jsqlparser.util.deparser.GrantDeParser;
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
    @Autowired
    GradientPriceService gradientPriceService;

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
        //房屋id
        for (int i = 1; i <= 200; i++) {
            //某房屋某月份的初始表用量
            BigDecimal nowMonthNums = new BigDecimal(0);
            //月份
            for (int i1 = 0; i1 < 3; i1++) {
                electricity.setHouseId(i);
                electricity.setMonth(String.format("%02d/%02d", year,month+i1));
                //本月随机写入[20,400)度用电量
                double randomSage = (int) ((Math.random() * 400 * 10000) + 20 * 10000) / 10000.0;
                nowMonthNums = BigDecimal.valueOf(randomSage).add(nowMonthNums);
                electricity.setNowMonthNums(nowMonthNums.doubleValue());
                electricity.setNowPrices(gradientPriceService.getPriceByUtilIdQuantity(2, randomSage).doubleValue());
                electricity.setState(1);
                electricityDao.insert(electricity);
            }
        }
    }
}

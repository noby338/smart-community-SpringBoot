package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.entity.Gas;
import com.woniuxy.smart_community.service.GradientPriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description 测试类
 * @Author noby
 * @Date 2022/7/8 14:39
 */
@SpringBootTest
class GasDaoTest {
    @Autowired
    GasDao gasDao;
    @Autowired
    GradientPriceService gradientPriceService;

    /**
     * 插入数据库数据
     */
    @Test
    void testInsert() {
        Gas gas = new Gas();
        int year = 2022;
        int month = 1;
        //房屋id
        for (int i = 1; i <= 200; i++) {
            //某房屋某月份的初始表用量
            BigDecimal nowMonthNums = new BigDecimal(0);
            //月份
            for (int i1 = 0; i1 < 3; i1++) {
                gas.setHouseId(i);
                gas.setMonth(String.format("%02d/%02d", year,month+i1));
                //本月随机写入[30,700)立方用气
                double randomSage = (int) ((Math.random() * 700 * 10000) + 30 * 10000) / 10000.0;
                nowMonthNums = BigDecimal.valueOf(randomSage).add(nowMonthNums);
                gas.setNowMonthNums(nowMonthNums.doubleValue());
                gas.setNowPrices(gradientPriceService.getPriceByUtilIdQuantity(2, randomSage).doubleValue());
                gas.setState(1);
                gasDao.insert(gas);
            }
        }
    }
}
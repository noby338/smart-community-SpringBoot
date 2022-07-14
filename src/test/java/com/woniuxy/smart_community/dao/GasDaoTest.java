package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.entity.Gas;
import com.woniuxy.smart_community.service.GradientPriceService;
import com.woniuxy.smart_community.service.UtilPriceService;
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
    @Autowired
    UtilPriceService utilPriceService;

    /**
     * 插入数据库数据
     */
    @Test
    void testInsert() {
        Gas gas = new Gas();
        //房屋id
        for (int i = 1; i <= 1920; i++) {
            for (int year = 2021; year <= 2022; year++) {
//                //某房屋某月份的初始表用量
//                BigDecimal nowMonthNums = new BigDecimal(0);
                if (year == 2021) {
                    for (int month = 10; month <= 12; month++) {
//                        gas.setHouseId(i);
                        gas.setMonth(String.format("%02d/%02d", year, month));
                        //本月随机写入[30,700)立方用气
                        double randomSage = (int) ((Math.random() * 700 * 10000) + 30 * 10000) / 10000.0;
                        gas.setNowMonthNums(randomSage);
                        gas.setNowPrices(utilPriceService.getPriceByUtilIdQuantity(2, randomSage).doubleValue());
                        gas.setState(1);
                        gas.setUtilPriceId(4);
                        gasDao.insert(gas);
                    }
                }
                if (year == 2022) {
                    for (int month = 10; month <= 12; month++) {
//                        gas.setHouseId(i);
                        gas.setMonth(String.format("%02d/%02d", year, month));
                        //本月随机写入[30,700)立方用气
                        double randomSage = (int) ((Math.random() * 700 * 10000) + 30 * 10000) / 10000.0;
                        gas.setNowMonthNums(randomSage);
                        gas.setNowPrices(utilPriceService.getPriceByUtilIdQuantity(2, randomSage).doubleValue());
                        gas.setState(1);
                        gas.setUtilPriceId(4);
                        gasDao.insert(gas);
                    }
                }

            }

        }
    }
}
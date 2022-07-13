package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.Gas;
import com.woniuxy.smart_community.entity.Water;
import com.woniuxy.smart_community.service.GradientPriceService;
import com.woniuxy.smart_community.service.UtilPriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @Description 测试类
 * @Author noby
 * @Date 2022/7/8 14:51
 */
@SpringBootTest
class WaterDaoTest {

    @Autowired
    WaterDao waterDao;
    @Autowired
    GradientPriceService gradientPriceService;
    @Autowired
    UtilPriceService utilPriceService;

    /**
     * 插入数据库数据
     */
    @Test
    void testInsert() {

        Water water = new Water();
        //房屋id
        for (int i = 1; i <= 1920; i++) {
            for (int year = 2021; year <= 2022; year++) {
//                //某房屋某月份的初始表用量
//                BigDecimal nowMonthNums = new BigDecimal(0);
                if (year == 2021) {
                    for (int month = 10; month <= 12; month++) {
//                        water.setHouseId(i);
                        water.setMonth(String.format("%02d/%02d", year, month));
                        //本月随机写入[2,40)立方用水
                        double randomSage = (int) ((Math.random() * 40 * 10000) + 2 * 10000) / 10000.0;
                        water.setNowMonthNums(randomSage);
                        water.setNowPrices(utilPriceService.getPriceByUtilIdQuantity(2, randomSage).doubleValue());
                        water.setState(1);
                        water.setUtilPriceId(3);
                        waterDao.insert(water);
                    }
                }
                if (year == 2022) {
                    for (int month = 1; month <= 3; month++) {
//                        water.setHouseId(i);
                        water.setMonth(String.format("%02d/%02d", year, month));
                        //本月随机写入[2,40)立方用水
                        double randomSage = (int) ((Math.random() * 40 * 10000) + 2 * 10000) / 10000.0;
                        water.setNowMonthNums(randomSage);
                        water.setNowPrices(utilPriceService.getPriceByUtilIdQuantity(2, randomSage).doubleValue());
                        water.setState(1);
                        water.setUtilPriceId(3);
                        waterDao.insert(water);
                    }
                }

            }

        }
    }
}
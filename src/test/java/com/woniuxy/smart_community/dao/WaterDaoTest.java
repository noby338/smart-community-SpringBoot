package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.Gas;
import com.woniuxy.smart_community.entity.Water;
import com.woniuxy.smart_community.service.GradientPriceService;
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

    /**
     * 插入数据库数据
     */
    @Test
    void testInsert() {
        Water water = new Water();
        int year = 2022;
        int month = 1;
        //房屋id
        for (int i = 1; i <= 200; i++) {
            //某房屋某月份的初始表用量
            BigDecimal nowMonthNums = new BigDecimal(0);
            //月份
            for (int i1 = 0; i1 < 3; i1++) {
                water.setHouseId(i);
                water.setMonth(String.format("%02d/%02d", year,month+i1));
                //本月随机写入[2,40)立方用水
                double randomSage = (int) ((Math.random() * 40 * 10000) + 2 * 10000) / 10000.0;
                nowMonthNums = BigDecimal.valueOf(randomSage).add(nowMonthNums);
                water.setNowMonthNums(nowMonthNums.doubleValue());
                water.setNowPrices(gradientPriceService.getPriceByUtilIdQuantity(2, randomSage).doubleValue());
                water.setState(1);
                waterDao.insert(water);
            }
        }
    }
}
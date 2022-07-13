package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.GradientPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Description 测试类
 * @Author noby
 * @Date 2022/7/8 9:28
 */
@SpringBootTest
class GradientPriceDaoTest {
    @Autowired
    GradientPriceDao gradientPriceDao;

    @Test
    void testSelectByUtilId() {
        List<GradientPrice> gradientPrices = gradientPriceDao.selectByUtilId(2);
        System.out.println("gradientPrices = " + gradientPrices);
    }
}
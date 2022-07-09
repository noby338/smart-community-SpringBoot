package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.dao.GradientPriceDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description 测试类
 * @Author noby
 * @Date 2022/7/8 10:18
 */
@SpringBootTest
class GradientPriceServiceTest {
    @Autowired
    GradientPriceService gradientPriceService;

    /**
     * 通过单价id和用量计算价格
     */
    @Test
    void testGetPriceByUtilIdQuantity() {
        BigDecimal priceByUtilIdQuantity2 = gradientPriceService.getPriceByUtilIdQuantity(2, 150);
        BigDecimal priceByUtilIdQuantity3 = gradientPriceService.getPriceByUtilIdQuantity(2, 200);
        BigDecimal priceByUtilIdQuantity4 = gradientPriceService.getPriceByUtilIdQuantity(2, 300);
        System.out.println("150 = " + priceByUtilIdQuantity2);
        System.out.println("200 = " + priceByUtilIdQuantity3);
        System.out.println("300 = " + priceByUtilIdQuantity4);
    }
}
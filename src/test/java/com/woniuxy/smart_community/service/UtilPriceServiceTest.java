package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.UtilPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description 测试类
 * @Author noby
 * @Date 2022/7/11 17:48
 */
@SpringBootTest
class UtilPriceServiceTest {
    @Autowired
    UtilPriceService utilPriceService;

    @Test
    void testGetPriceByUtilIdQuantity() {
        BigDecimal priceByUtilIdQuantity2 = utilPriceService.getPriceByUtilIdQuantity(2, 150);
        BigDecimal priceByUtilIdQuantity3 = utilPriceService.getPriceByUtilIdQuantity(2, 200);
        BigDecimal priceByUtilIdQuantity4 = utilPriceService.getPriceByUtilIdQuantity(2, 300);
        System.out.println("150 = " + priceByUtilIdQuantity2);
        System.out.println("200 = " + priceByUtilIdQuantity3);
        System.out.println("300 = " + priceByUtilIdQuantity4);
    }
}
package com.woniuxy.smart_community.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

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
    @Test
    void getQantityAndCostArray() {
        List<double[]> quantityAndCostArray = utilPriceService.getQuantityAndCostArray(2);
        for (double[] doubles : quantityAndCostArray) {
            System.out.print("[");
            for (double aDouble : doubles) {
                System.out.print(aDouble+",");
            }
            System.out.print("]");
        }
    }
}
package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.dao.GradientPriceDao;
import com.woniuxy.smart_community.entity.GradientPrice;
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

    @Test
    void testUpdateByGradientPrice() {
        GradientPrice gradientPrice = new GradientPrice(4,"第二梯度",2,180.0,280.0,0.6224);
//        GradientPrice gradientPrice = new GradientPrice(5,"第二梯度",2,280.0,null,0.8224);
        gradientPriceService.updateByGradientPrice(gradientPrice);
    }

    @Test
    void testInsert() {
        GradientPrice gradientPrice = new GradientPrice(null, "第四梯度", 2, 500.0, 1.0, 0.9);
        gradientPriceService.insert(gradientPrice);
    }

    @Test
    void testDelete() {
        gradientPriceService.delectById(12);
    }

}
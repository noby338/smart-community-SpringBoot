package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.UtilPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description 测试类
 * @Author noby
 * @Date 2022/7/7 10:13
 */
@SpringBootTest
class UtilPriceDaoTest {
    @Autowired
    UtilPriceDao utilPriceDao;

    @Test
    void testSelectAll() {
        List<UtilPrice> utilPrices = utilPriceDao.selectAll();
        System.out.println("utilPrices = " + utilPrices);
    }
}
package com.woniuxy.smart_community;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class SmartCommunityApplicationTests {


    @Test
    void contextLoads() {
        BigDecimal a=new BigDecimal(1);

        a=a.add(new BigDecimal(1)).multiply(new BigDecimal(2)).subtract(new BigDecimal(4));
        System.out.println(a);

    }

}

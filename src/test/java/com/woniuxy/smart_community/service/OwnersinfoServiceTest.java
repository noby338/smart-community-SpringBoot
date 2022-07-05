package com.woniuxy.smart_community.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OwnersinfoServiceTest {

    @Autowired
    OwnersInfoService ownersInfoService;

    @Test
    void test01(){
        System.out.println(ownersInfoService.getOwnameByOwid(1));
    }

}

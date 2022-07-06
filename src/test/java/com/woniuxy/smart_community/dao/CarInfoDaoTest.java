package com.woniuxy.smart_community.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/6 16:39
 */
@SpringBootTest
public class CarInfoDaoTest {
    @Autowired
    CarInfoDao carInfoDao;

    @Test
    void test01(){
        System.out.println(carInfoDao.selectCarInfoByCarid(1));
    }
    @Test
    void test02(){
        System.out.println(carInfoDao.selectAllCarInfos());
    }



}

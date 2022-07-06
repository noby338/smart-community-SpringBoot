package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.HouseHold;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName -> HouseHoldDaoTset
 * @Author Fiver_Hu
 * @Date 2022/7/5 20:58 星期二
 * @Version 1.0
 **/
@SpringBootTest
public class HouseHoldDaoTset {
    @Autowired
    HouseHoldDao houseHoldDao;

    @Test
    public void insertTest(){
        HouseHold houseHold = new HouseHold();
        for(int i =0;i<50;i++){
            houseHold.setId(i);
            houseHold.setAge(i%24);
            houseHold.setGender(true);
            houseHold.setName("i");
            houseHold.setTelephone("1346789");
            houseHold.set_owner(false);
            houseHold.setState(i%2);
            houseHoldDao.insert(houseHold);
        }

    }

    @Test
    public void selectHouseHoldByHouseHoldInfoTest(){
        HouseHold houseHold = new HouseHold();
        houseHold.setAge(1);
        System.out.println(houseHoldDao.selectHouseHoldByHouseHoldInfo(houseHold));
    }
}
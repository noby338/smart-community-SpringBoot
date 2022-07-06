package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.OwnersInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OwnersInfoDaoTest {
    @Autowired
    OwnerInfoDao ownerInfoDao;

    @Test
    void test01(){
        System.out.println(ownerInfoDao.selectAll());
    }

    @Test
    void test03(){
        System.out.println(ownerInfoDao.selectOwnameByOwid(1));
    }

    @Test
    void test02(){
        OwnersInfo OwnersInfo = new OwnersInfo();
        OwnersInfo.setOwname("zs");
        System.out.println(ownerInfoDao.selectOwnerByOwnerinfo(OwnersInfo));
    }

    @Test
    void test04(){
        System.out.println(ownerInfoDao.selectOwnerByOwnameAndPhone("zs","123331"));
    }

    //添加
    @Test
    void testinsert01(){
        OwnersInfo OwnersInfo=new OwnersInfo(null, "xh","12332988976","小区业主",4);
        ownerInfoDao.insertOwnerinfo(OwnersInfo);
    }


    //update
    @Test
    void testup01(){
        OwnersInfo ownersifo=new OwnersInfo();
        ownersifo.setOwid(1);
        ownersifo.setOwname("zs");
        ownersifo.setId(4);
        ownerInfoDao.updateOwnerByOwnerinfo(ownersifo);
    }

}

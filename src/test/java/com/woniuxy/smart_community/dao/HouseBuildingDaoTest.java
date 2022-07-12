package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.HouseBuilding;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author :  Fiver_Hu
 * @Date : 2022/7/9 11:24 星期六
 * @Project_Name -> smart-community
 * @Package_Name -> com.woniuxy.smart_community.dao
 * @ClassName -> HouseBuildingDao
 * @Version 1.0
 **/
@SpringBootTest
public class HouseBuildingDaoTest {

    @Autowired
            HouseBuildingDao houseBuildingDao;

    //添加
    @Test
    public void insertHouseBuilding(){
        HouseBuilding houseBuilding = new HouseBuilding();
        houseBuilding.setName("测试");
        houseBuildingDao.insertHouseBuilding(houseBuilding);
    }

    //删除
    @Test
    public void deleteHouseBuilding(){
        HouseBuilding houseBuilding = new HouseBuilding();
        houseBuilding.setId(23);
        houseBuildingDao.deleteHouseBuilding(houseBuilding);
    }

    //修改
    @Test
    public void updateHouseBuilding(){
        HouseBuilding houseBuilding = new HouseBuilding();
        houseBuilding.setId(23);
        houseBuilding.setName("测试2");
        houseBuildingDao.updateHouseBuilding(houseBuilding);
    }

    //查询
    @Test
    public void selectHouseBuilding(){
        HouseBuilding houseBuilding = new HouseBuilding();
        houseBuilding.setId(22);
        houseBuilding.setName("测试");
        List<HouseBuilding> houseBuilding1 = houseBuildingDao.selectHouseBuilding(houseBuilding);
        System.out.println(houseBuilding1);
    }

}

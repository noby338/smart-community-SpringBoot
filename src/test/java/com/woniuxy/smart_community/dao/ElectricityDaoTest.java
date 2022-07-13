package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.*;
import com.woniuxy.smart_community.service.GradientPriceService;
import com.woniuxy.smart_community.service.HouseService;
import net.sf.jsqlparser.util.deparser.GrantDeParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description 电费表dao测试类
 * @Author noby
 * @Date 2022/7/6 14:47
 */
@SpringBootTest
class ElectricityDaoTest {
    @Autowired
    ElectricityDao electricityDao;
    @Autowired
    GradientPriceService gradientPriceService;
    @Autowired
    HouseService houseService;

    @Test
    void selectByElectricity() {
        Electricity electricity = electricityDao.selectByElectricity(1);
        System.out.println("electricity = " + electricity);
    }

    /**
     * 插入数据库数据
     */
    @Test
    void insertData() {
//        Electricity electricity = new Electricity();
//        //房屋id
//        for (int i = 1; i <= 1920; i++) {
//            for(int year=2021;year<=2022;year++) {
//                //某房屋某月份的初始表用量
//                BigDecimal nowMonthNums = new BigDecimal(0);
//                if (year==2021) {
//                    for (int month = 10; month <= 12; month++) {
//                        electricity.setHouseId(i);
//                        electricity.setMonth(String.format("%02d/%02d", year,month));
//                        //本月随机写入[20,400)度用电量
//                        double randomSage = (int) ((Math.random() * 400 * 10000) + 20 * 10000) / 10000.0;
//                        nowMonthNums = BigDecimal.valueOf(randomSage).add(nowMonthNums);
//                        electricity.setNowMonthNums(nowMonthNums.doubleValue());
//                        electricity.setNowPrices(gradientPriceService.getPriceByUtilIdQuantity(2, randomSage).doubleValue());
//                        electricity.setState(1);
//                        electricity.setUtilPriceId(2);
//                        electricityDao.insert(electricity);
//                    }
//                }
//                if(year == 2022) {
//                    for (int month = 1; month <= 3; month++) {
//                        electricity.setHouseId(i);
//                        electricity.setMonth(String.format("%02d/%02d", year,month));
//                        //本月随机写入[20,400)度用电量
//                        double randomSage = (int) ((Math.random() * 400 * 10000) + 20 * 10000) / 10000.0;
//                        nowMonthNums = BigDecimal.valueOf(randomSage).add(nowMonthNums);
//                        electricity.setNowMonthNums(nowMonthNums.doubleValue());
//                        electricity.setNowPrices(gradientPriceService.getPriceByUtilIdQuantity(2, randomSage).doubleValue());
//                        electricity.setState(1);
//                        electricity.setUtilPriceId(2);
//                        electricityDao.insert(electricity);
//                    }
//                }
//
//            }
//        }
    }

    /**
     * 通过月份查数据
     */
    @Test
    void selectByMonth() {
        List<Electricity> electricities = electricityDao.selectByMonth("2022/01");
        System.out.println("electricities = " + electricities);
    }

    /**
     * 通过楼栋查数据
     */
    @Test
    void selectByBuildingId() {
//        List<Integer> houseIdList = new ArrayList<>();
//        List<HouseBuilding> houseBuildingList = electricityDao.selectByBuildingId(2);
//        for (HouseBuilding houseBuilding : houseBuildingList) {
//            List<HouseUnit> houseUnitList = houseBuilding.getHouseUnitList();
//            for (HouseUnit houseUnit : houseUnitList) {
//                List<HouseFloor> houseFloorList = houseUnit.getHouseFloorList();
//                for (HouseFloor houseFloor : houseFloorList) {
//                    List<House> houseList = houseFloor.getHouseList();
//                    for (House house : houseList) {
//                        houseIdList.add(house.getId());
//                    }
//                }
//            }
//        }
        HouseInfo houseInfo = new HouseInfo();
//        houseInfo.setUnitId(1);
        ArrayList<Integer> houseIdList = houseService.selectHouseById(houseInfo);
        List<Electricity> electricityList = electricityDao.selectElectricityByHouseIdListAndMonth(houseIdList,"2021/12");
        System.out.println("electricityList = " + electricityList);
    }
}

package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.woniuxy.smart_community.dao.ElectricityDao;
import com.woniuxy.smart_community.dao.HouseDao;
import com.woniuxy.smart_community.dao.PropertyCardDao;
import com.woniuxy.smart_community.dao.WaterDao;
import com.woniuxy.smart_community.entity.*;
import com.woniuxy.smart_community.service.ElectricityService;
import com.woniuxy.smart_community.service.UtilPriceService;
import com.woniuxy.smart_community.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/12 20:05
 */
@Service
public class WaterServiceImpl implements WaterService {

    @Autowired
    WaterDao waterDao;
    @Autowired
    HouseDao houseDao;
    @Autowired
    PropertyCardDao propertyCardDao;
    @Autowired
    UtilPriceService utilPriceService;

    @Override
    public List<Water> selectWaterByHouseIdListAndMonth(List<Integer> houseIdList, String month, int pageNum) {
        PageHelper.startPage(pageNum, 10);
        return waterDao.selectWaterByHouseIdListAndMonth(houseIdList, month);
    }

    @Override
    public Double selectWaterSumByHouseIdListAndMonth(List<Integer> houseIdList, String month) {
        return waterDao.selectWaterSumByHouseIdListAndMonth(houseIdList, month);
    }

    @Override
    public void insertWater(Calendar calendar) {
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH);
        String month = String.format("%02d/%02d", y, m);
        Water water = new Water();

        List<House> houses = houseDao.selectAllHouseForCarShow();
        for (House house : houses) {
            water.setHouse(house);
            water.setMonth(month);
            water.setNowMonthNums(0.0);
            water.setNowPrices(0.0);
            PropertyCard propertyCard = propertyCardDao.selectByCardNumber(house.getHouseNum());
            water.setState(propertyCard.getState());
            water.setUtilPriceId(3);
            waterDao.insert(water);
        }
    }

    @Override
    public void updateWaterByCalenderAndDosage(int id, Calendar calendar, double dosage) {
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH);
        String month = String.format("%02d/%02d", y, m);
        BigDecimal price = utilPriceService.getPriceByUtilIdQuantity(3, dosage);
        Water water = new Water();
        House house = new House();
        house.setId(id);
        water.setHouse(house);
        water.setMonth(month);
        water.setNowMonthNums(dosage);
        water.setNowPrices(price.doubleValue());
        System.out.println("electricity = " + water);
        waterDao.updateByWater(water);
    }
}

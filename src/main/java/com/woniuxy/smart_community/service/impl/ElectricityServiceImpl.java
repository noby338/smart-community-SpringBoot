package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.sun.javafx.collections.ElementObservableListDecorator;
import com.woniuxy.smart_community.dao.ElectricityDao;
import com.woniuxy.smart_community.dao.HouseDao;
import com.woniuxy.smart_community.dao.PropertyCardDao;
import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.entity.House;
import com.woniuxy.smart_community.entity.PropertyCard;
import com.woniuxy.smart_community.service.ElectricityService;
import com.woniuxy.smart_community.service.PropertyCardService;
import com.woniuxy.smart_community.service.UtilPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/12 20:05
 */
@Service
public class ElectricityServiceImpl implements ElectricityService {

    @Autowired
    ElectricityDao electricityDao;
    @Autowired
    PropertyCardDao propertyCardDao;
    @Autowired
    HouseDao houseDao;
    @Autowired
    UtilPriceService utilPriceService;
    @Autowired
    PropertyCardService propertyCardService;

    @Override
    public List<Electricity> selectElectricityByHouseIdListAndMonth(List<Integer> houseIdList, String month, int pageNum) {
        PageHelper.startPage(pageNum, 10);
        return electricityDao.selectElectricityByHouseIdListAndMonth(houseIdList, month);
    }

    @Override
    public Double selectElectricitySumByHouseIdListAndMonth(List<Integer> houseIdList, String month) {
        return electricityDao.selectElectricitySumByHouseIdListAndMonth(houseIdList, month);

    }
    /**
     * 所有房间添加新一月的电费表
     * @param calendar 日期
     */
    @Override
    public void insertElectricity(Calendar calendar) {
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH);
        String month = String.format("%02d/%02d", y, m);
        Electricity electricity = new Electricity();

        List<House> houses = houseDao.selectAllHouseForCarShow();
        for (House house : houses) {
            electricity.setHouse(house);
            electricity.setMonth(month);
            electricity.setNowMonthNums(0.0);
            electricity.setNowPrices(0.0);
            PropertyCard propertyCard = propertyCardDao.selectByCardNumber(house.getHouseNum());
            electricity.setState(propertyCard.getState());
            electricity.setUtilPriceId(2);
            electricityDao.insert(electricity);
        }
    }
    /**
     * 根据房屋 Id 、用量、月份更新该月房屋月末的用量和总费用
     * 总费用将会根据用量自动计算
     * @param id 房屋 Id
     * @param calendar 月份
     * @param dosage 本月用量
     */
    @Override
    public void updateElectricityByCalenderAndDosage(int id, Calendar calendar, double dosage) {
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH);
        String month = String.format("%02d/%02d", y, m);
        BigDecimal price = utilPriceService.getPriceByUtilIdQuantity(2, dosage);
        Electricity electricity = new Electricity();
        House house = new House();
        house.setId(id);
        electricity.setHouse(house);
        electricity.setMonth(month);
        electricity.setNowMonthNums(dosage);
        electricity.setNowPrices(price.doubleValue());
        System.out.println("electricity = " + electricity);
        electricityDao.updateByElectricity(electricity);

        //自动扣费
        PropertyCard propertyCard = propertyCardDao.selectByHouseId(id);
        propertyCardService.updateLastMoneyAndState(propertyCard.getId(),-(price.doubleValue()));

    }
}

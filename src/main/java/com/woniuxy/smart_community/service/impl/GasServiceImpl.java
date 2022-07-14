package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.woniuxy.smart_community.dao.GasDao;
import com.woniuxy.smart_community.dao.HouseDao;
import com.woniuxy.smart_community.dao.PropertyCardDao;
import com.woniuxy.smart_community.dao.WaterDao;
import com.woniuxy.smart_community.entity.*;
import com.woniuxy.smart_community.service.GasService;
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
public class GasServiceImpl implements GasService {

    @Autowired
    GasDao gasDao;
    @Autowired
    HouseDao houseDao;
    @Autowired
    PropertyCardDao propertyCardDao;
    @Autowired
    UtilPriceService utilPriceService;


    @Override
    public List<Gas> selectGasByHouseIdListAndMonth(List<Integer> houseIdList, String month, int pageNum) {
        PageHelper.startPage(pageNum, 10);
        return gasDao.selectGasByHouseIdListAndMonth(houseIdList, month);
    }

    @Override
    public Double selectGasSumByHouseIdListAndMonth(List<Integer> houseIdList, String month) {
        return gasDao.selectGasSumByHouseIdListAndMonth(houseIdList,month);
    }

    @Override
    public void insertGas(Calendar calendar) {
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH);
        String month = String.format("%02d/%02d", y, m);
        Gas gas = new Gas();

        List<House> houses = houseDao.selectAllHouseForCarShow();
        for (House house : houses) {
            gas.setHouse(house);
            gas.setMonth(month);
            gas.setNowMonthNums(0.0);
            gas.setNowPrices(0.0);
            PropertyCard propertyCard = propertyCardDao.selectByCardNumber(house.getHouseNum());
            gas.setState(propertyCard.getState());
            gas.setUtilPriceId(4);
            gasDao.insert(gas);
        }
    }

    @Override
    public void updateGasByCalenderAndDosage(int id, Calendar calendar, double dosage) {
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH);
        String month = String.format("%02d/%02d", y, m);
        BigDecimal price = utilPriceService.getPriceByUtilIdQuantity(4, dosage);
        Gas gas = new Gas();
        House house = new House();
        house.setId(id);
        gas.setHouse(house);
        gas.setMonth(month);
        gas.setNowMonthNums(dosage);
        gas.setNowPrices(price.doubleValue());
        System.out.println("electricity = " + gas);
        gasDao.updateByGas(gas);

    }
}

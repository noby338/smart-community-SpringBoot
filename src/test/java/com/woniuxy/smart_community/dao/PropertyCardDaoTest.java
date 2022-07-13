package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.House;
import com.woniuxy.smart_community.entity.LimitMoney;
import com.woniuxy.smart_community.entity.PropertyCard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.ProcessorErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description 测试类
 * @Author noby
 * @Date 2022/7/13 18:54
 */
@SpringBootTest
class PropertyCardDaoTest {
    @Autowired
    PropertyCardDao propertyCardDao;
    @Autowired
    HouseDao houseDao;

    @Test
    void testInsert() {
        PropertyCard propertyCard = new PropertyCard();
        List<House> houses = houseDao.selectAllHouseForCarShow();
        for (House house : houses) {
            propertyCard.setCardNumber(house.getHouseNum());
//            propertyCard.setHouseId(house.getId());
            double radomLastMoney = (int)((Math.random() * 1500 * 100) + -300 * 100) / 100.0;
            propertyCard.setLastMoney(radomLastMoney);
            LimitMoney limitMoney = new LimitMoney();
            limitMoney.setId(1);
            limitMoney.setLimitMoney(200.0);
            if (radomLastMoney >= 0) {
                propertyCard.setState(1);
            } else if (radomLastMoney < 0 && radomLastMoney > -200 ){
                propertyCard.setState(2);
            } else {
                propertyCard.setState(3);
            }
            propertyCard.setLimitMoney(limitMoney);
            propertyCardDao.insert(propertyCard);
        }

    }
}
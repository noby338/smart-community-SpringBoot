package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.woniuxy.smart_community.dao.GasDao;
import com.woniuxy.smart_community.dao.LimitMoneyDao;
import com.woniuxy.smart_community.dao.PropertyCardDao;
import com.woniuxy.smart_community.entity.Gas;
import com.woniuxy.smart_community.entity.LimitMoney;
import com.woniuxy.smart_community.entity.PropertyCard;
import com.woniuxy.smart_community.service.GasService;
import com.woniuxy.smart_community.service.PropertyCardService;
import org.apache.tomcat.jni.ProcErrorCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.rmi.PortableRemoteObject;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/12 20:05
 */
@Service
public class PropertyCardServiceImpl implements PropertyCardService {

    @Autowired
    PropertyCardDao propertyCardDao;
    @Autowired
    LimitMoneyDao limitMoneyDao;

    @Override
    public PropertyCard selectByCarNumber(String carNumber) {
        PropertyCard propertyCard = propertyCardDao.selectByCardNumber(carNumber);
        return propertyCard;
    }

    @Override
    public void charge(PropertyCard propertyCard,Double addMoney) {
        BigDecimal total = new BigDecimal(propertyCard.getLastMoney() + "").add(new BigDecimal(addMoney + ""));
        BigDecimal limitDe = new BigDecimal(limitMoneyDao.selectById(1).getLimitMoney() + "");
        int flag = total.compareTo(limitDe);//缴费后的总费用是否大于-200
        int flag2 = total.compareTo(new BigDecimal(0));//缴费后的费用是否大于0
        int state;
        if (flag2 == 1) {
            state = 1;
        } else if(flag == -1){
            state = 3;
        } else {
            state = 2;
        }
        propertyCard.setLastMoney(total.doubleValue());
        propertyCard.setState(state);
        propertyCardDao.update(propertyCard);
    }
}

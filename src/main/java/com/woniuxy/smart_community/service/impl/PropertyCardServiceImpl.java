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

    /**
     * 根据房卡编号查询房卡对象
     * @param cardNumber 房卡编号
     * @return 房卡对象
     */
    @Override
    public PropertyCard selectByCardNumber(String cardNumber) {
        PropertyCard propertyCard = propertyCardDao.selectByCardNumber(cardNumber);
        return propertyCard;
    }

    /**
     * 根据房卡Id修改该房卡的费用和房卡状态(费用为变更量，而非直接设置量)
     * 房卡的状态根据新余额自动变更
     * @param propertyCardId 房卡id
     * @param addMoney 增加的费用
     */
    @Override
    public void updateLastMoneyAndState(int propertyCardId, Double addMoney) {
        PropertyCard propertyCard1 = propertyCardDao.selectById(propertyCardId);
        BigDecimal total = new BigDecimal(propertyCard1.getLastMoney()+"").add(new BigDecimal(addMoney + ""));
        BigDecimal limitDe = new BigDecimal(-limitMoneyDao.selectById(1).getLimitMoney() + "");
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
        propertyCard1.setLastMoney(total.doubleValue());
        propertyCard1.setState(state);
        propertyCardDao.update(propertyCard1);
    }
}

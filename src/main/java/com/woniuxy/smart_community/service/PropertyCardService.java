package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.PropertyCard;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/13 19:33
 */
public interface PropertyCardService {
    /**
     * 根据房卡编号查询房卡对象
     * @param cardNumber 房卡编号
     * @return 房卡对象
     */
    PropertyCard selectByCardNumber(String cardNumber);

    /**
     * 根据房卡Id修改该房卡的费用和房卡状态(费用为变更量，而非直接设置量)
     * 房卡的状态根据新余额自动变更
     * @param propertyCardId 房卡id
     * @param addMoney 增加的费用
     */
    void updateLastMoneyAndState(int propertyCardId, Double addMoney);

}

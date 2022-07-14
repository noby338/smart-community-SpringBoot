package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.PropertyCard;

import java.util.List;

/**
 * @Description 物业卡
 * @Author noby
 * @Date 2022/7/13 18:51
 */
public interface PropertyCardDao {
    void insert(PropertyCard propertyCard);
    PropertyCard selectByCardNumber(String cardNumber);
    PropertyCard selectById(int id);
    void update (PropertyCard propertyCard);

}

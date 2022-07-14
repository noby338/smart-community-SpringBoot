package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.PropertyCard;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/13 19:33
 */
public interface PropertyCardService {
    PropertyCard selectByCarNumber(String carNumber);
    void charge(PropertyCard propertyCard,Double addMoney);
}

package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.woniuxy.smart_community.dao.GasDao;
import com.woniuxy.smart_community.dao.PropertyCardDao;
import com.woniuxy.smart_community.entity.Gas;
import com.woniuxy.smart_community.entity.PropertyCard;
import com.woniuxy.smart_community.service.GasService;
import com.woniuxy.smart_community.service.PropertyCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public PropertyCard selectByCarNumber(String carNumber) {
        PropertyCard propertyCard = propertyCardDao.selectByCardNumber(carNumber);
        return propertyCard;
    }
}

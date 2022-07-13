package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.woniuxy.smart_community.dao.ElectricityDao;
import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.service.ElectricityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public List<Electricity> selectElectricityByHouseIdListAndMonth(List<Integer> houseIdList, String month,int pageNum) {
        PageHelper.startPage(pageNum, 10);
        return electricityDao.selectElectricityByHouseIdListAndMonth(houseIdList, month);
    }
}

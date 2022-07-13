package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.woniuxy.smart_community.dao.ElectricityDao;
import com.woniuxy.smart_community.dao.WaterDao;
import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.entity.Water;
import com.woniuxy.smart_community.service.ElectricityService;
import com.woniuxy.smart_community.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/12 20:05
 */
@Service
public class WaterServiceImpl implements WaterService {

    @Autowired
    WaterDao waterDao;
    @Override
    public List<Water> selectWaterByHouseIdListAndMonth(List<Integer> houseIdList, String month, int pageNum) {
        PageHelper.startPage(pageNum, 10);
        return waterDao.selectWaterByHouseIdListAndMonth(houseIdList, month);
    }
}

package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.woniuxy.smart_community.dao.GasDao;
import com.woniuxy.smart_community.dao.WaterDao;
import com.woniuxy.smart_community.entity.Gas;
import com.woniuxy.smart_community.entity.Water;
import com.woniuxy.smart_community.service.GasService;
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
public class GasServiceImpl implements GasService {

    @Autowired
    GasDao gasDao;
    @Override
    public List<Gas> selectGasByHouseIdListAndMonth(List<Integer> houseIdList, String month, int pageNum) {
        PageHelper.startPage(pageNum, 10);
        return gasDao.selectGasByHouseIdListAndMonth(houseIdList, month);
    }
}

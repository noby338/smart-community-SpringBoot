package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.entity.Water;

import java.util.List;

public interface WaterService {
    List<Water> selectWaterByHouseIdListAndMonth(List<Integer> houseIdList, String month, int pageNum);
}




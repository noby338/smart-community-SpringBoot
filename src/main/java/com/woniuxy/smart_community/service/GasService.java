package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.Gas;
import com.woniuxy.smart_community.entity.Water;

import java.util.List;

public interface GasService {
    List<Gas> selectGasByHouseIdListAndMonth(List<Integer> houseIdList, String month, int pageNum);
}




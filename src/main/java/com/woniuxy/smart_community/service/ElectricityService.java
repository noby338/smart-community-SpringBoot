package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.entity.HouseBuilding;

import java.util.List;

public interface ElectricityService {
    List<Electricity> selectElectricityByHouseIdListAndMonth(List<Integer> houseIdList,String month,int pageNum);
}




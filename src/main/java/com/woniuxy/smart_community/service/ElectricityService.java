package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.entity.HouseBuilding;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface ElectricityService {
    /**
     * 级联查询
     * @param houseIdList
     * @param month
     * @param pageNum
     * @return
     */
    List<Electricity> selectElectricityByHouseIdListAndMonth(List<Integer> houseIdList, String month, int pageNum);

    /**
     * 级联查询用量统计
     * @param houseIdList
     * @param month
     * @return
     */
    Double selectElectricitySumByHouseIdListAndMonth(List<Integer> houseIdList, String month);

    /**
     * 所有房间添加新一月的电费表
     * @param calendar 日期
     */
    void insertElectricity(Calendar calendar);

    /**
     * 根据房屋 Id 、用量、月份更新该月房屋月末的用量和总费用
     * 总费用将会根据用量自动计算
     * 将根据费用自动在物业卡中扣费
     * @param id 房屋 Id
     * @param calendar 月份
     * @param dosage 本月用量
     */
    void updateElectricityByCalenderAndDosage (int id,Calendar calendar,double dosage);

}




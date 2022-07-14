package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.entity.Water;

import java.util.Calendar;
import java.util.List;

public interface WaterService {
    List<Water> selectWaterByHouseIdListAndMonth(List<Integer> houseIdList, String month, int pageNum);
    Double selectWaterSumByHouseIdListAndMonth(List<Integer> houseIdList, String month);
    /**
     * 所有房间添加新一月的水费表
     * @param calendar 日期
     */
    void insertWater(Calendar calendar);

    /**
     * 根据房屋 Id 、用量、月份更新该月房屋月末的用量和总费用
     * 总费用将会根据用量自动计算
     * @param id 房屋 Id
     * @param calendar 月份
     * @param dosage 本月用量
     */
    void updateWaterByCalenderAndDosage (int id,Calendar calendar,double dosage);
}




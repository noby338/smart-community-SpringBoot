package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.Gas;
import com.woniuxy.smart_community.entity.Water;

import java.util.Calendar;
import java.util.List;

public interface GasService {
    List<Gas> selectGasByHouseIdListAndMonth(List<Integer> houseIdList, String month, int pageNum);
    Double selectGasSumByHouseIdListAndMonth(List<Integer> houseIdList, String month);
    /**
     * 所有房间添加新一月的气费表
     * @param calendar 日期
     */
    void insertGas(Calendar calendar);

    /**
     * 根据房屋 Id 、用量、月份更新该月房屋月末的用量和总费用
     * 总费用将会根据用量自动计算
     * @param id 房屋 Id
     * @param calendar 月份
     * @param dosage 本月用量
     */
    void updateGasByCalenderAndDosage (int id,Calendar calendar,double dosage);
}




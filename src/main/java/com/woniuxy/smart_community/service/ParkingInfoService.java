package com.woniuxy.smart_community.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.ParkingInfo;


/**
 * @Description 车位管理
 * @Author LittleCode
 * @Date 2022/7/6 17:51
 */
public interface ParkingInfoService {
    /**
     * 分页查询车位信息
     * @param pageIndex
     * @param pageSize
     * @param parkingInfo
     * @return
     */ //使用
    PageInfo<ParkingInfo> getParkingInfoByPage(int pageIndex, int pageSize, ParkingInfo parkingInfo);
    void addParkingInfo(ParkingInfo parkingInfo);
    void removeParkingInfoByParkId(int parkId);
    void changeParkingInfo(ParkingInfo parkingInfo);

}

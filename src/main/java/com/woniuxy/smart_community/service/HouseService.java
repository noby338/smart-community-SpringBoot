package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.House;
import com.woniuxy.smart_community.entity.HouseBuilding;
import com.woniuxy.smart_community.entity.HouseInfo;
import com.woniuxy.smart_community.entity.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Fiver_Hu
 * @Date 2022/7/6 11:04 星期三
 * @Project_Name smart-community
 * @Package_Name com.woniuxy.smart_community.service
 * @ClassName -> HouseService
 * @Version 1.0
 **/

public interface HouseService {

    /**
     * 通过房间信息查询相关数据
     *
     * @param houseInfo 房间号
     * @return 实例对象
     */
    ArrayList<Integer> selectHouseById(HouseInfo houseInfo);


    /**
     * 通过房间信息查询相关数据
     *
     * @param houseInfo 房间号
     * @return 实例对象
     */
    ArrayList<House> selectHouse(HouseInfo houseInfo);


    /**
     * 通过房间信息查询相关数据
     *
     * @param houseInfo 房间号
     * @return 实例对象
     */
    ResponseEntity selectAllHouse(HouseInfo houseInfo);

    ResponseEntity<List<HouseBuilding>> selectAllHouseByBuilding();

    /**
     * 通过主键修改房间信息数据
     *
     * @param houseInfo 实例对象
     * @return 影响行数
     */
    ResponseEntity updateHouse(HouseInfo houseInfo);



}

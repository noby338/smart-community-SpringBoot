package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.House;
import com.woniuxy.smart_community.entity.ResponseEntity;
import org.apache.ibatis.annotations.Param;

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
     * 新增房间数据
     *
     * @param house 实例对象
     * @return 影响行数
     */
    int insertHouse(@Param("house") House house);

    /**
     * 通过主键删除房间信息数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteHouseById(Integer id);

    /**
     * 通过主键修改房间信息数据
     *
     * @param house 实例对象
     * @return 影响行数
     */
    int updateHouse(@Param("house") House house);

    /**
     * 通过房间信息查询相关数据
     *
     * @param house 房间号
     * @return 实例对象
     */
    ResponseEntity selectHouseByHouseInfo(House house, int pageNum, int pageSize);

    /**
     * 根据房间信息统计总行数
     *
     * @param house 查询条件
     * @return 总行数
     */
    Integer countHouses(@Param("house") House house);

}

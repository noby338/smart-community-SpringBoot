package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.House;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName -> HouseDao
 * @Author Fiver_Hu
 * @Date 2022/7/5 15:12 星期二
 * @Version 1.0
 **/

public interface HouseDao {

    /**
     * 通过房间号查询单条数据
     *
     * @param houseNum 房间号
     * @return 实例对象
     */
    House selectHouseByHouseNum(Integer houseNum);

    /**
     * 通过房间信息查询相关数据
     *
     * @param houseinfo 房间号
     * @return 实例对象
     */
    List<House> selectHouseByHouseInfo(@Param("houseinfo") House houseinfo);

    /**
     * 新增房间数据
     *
     * @param house 实例对象
     * @return 影响行数
     */
    int insert(@Param("house")House house);

    /**
     * 通过主键修改房间信息数据
     *
     * @param house 实例对象
     * @return 影响行数
     */
    int update(@Param("house") House house);

    /**
     * 通过主键删除房间信息数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 根据房间信息统计总行数
     *
     * @param house 查询条件
     * @return 总行数
     */
    int count(@Param("house") House house);

}

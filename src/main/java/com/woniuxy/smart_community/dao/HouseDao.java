package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.House;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName -> HouseDao
 * @Author Fiver_Hu
 * @Date 2022/7/5 15:12 星期二
 * @Version 1.0
 **/
public interface HouseDao {

    /**
     * 新增房间数据
     *
     * @param house 实例对象
     * @return 影响行数
     */
//    int insertHouse(@Param("house")House house);
    int insertHouse(@Param("house") House house);

    /**
     * 通过主键删除房间信息数据
     *
     * @param house 实例对象
     * @return 影响行数
     */
    int deleteHouse(@Param("house") House house);

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
    List<House> selectHouse(@Param("house") House house);

}

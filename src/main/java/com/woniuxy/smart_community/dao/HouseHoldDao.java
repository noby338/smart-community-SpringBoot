package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.HouseHold;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName -> HouseHoldDao
 * @Author Fiver_Hu
 * @Date 2022/7/5 15:12 星期二
 * @Version 1.0
 **/
public interface HouseHoldDao {

    /**
     * 查询人口信息
     *
     * @param houseHold 实例对象
     * @return 影响行数
     */
    List<HouseHold> selectHouseHoldByHouseHoldInfo(
            @Param("houseHold") HouseHold houseHold);


    /**
     * 新增人口信息数据
     *
     * @param houseHold 实例对象
     * @return 影响行数
     */
    int insert(@Param("houseHold") HouseHold houseHold);


    /**
     * 根据人口信息修改数据
     *
     * @param houseHold 实例对象
     * @return 影响行数
     */
    int update(@Param("houseHold") HouseHold houseHold);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteByHouseId(Integer id);

    /**
     * 根据信息统计总行数
     *
     * @param houseHold 查询条件
     * @return 总行数
     */
    int count(@Param("houseHold") HouseHold houseHold);
}

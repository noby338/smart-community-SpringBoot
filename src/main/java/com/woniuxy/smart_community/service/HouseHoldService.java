package com.woniuxy.smart_community.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.HouseHold;
import com.woniuxy.smart_community.entity.HouseParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author :  Fiver_Hu
 * @Date : 2022/7/11 16:44 星期一
 * @Project_Name -> smart-community
 * @Package_Name -> com.woniuxy.smart_community.service
 * @ClassName -> HouseHoldService
 * @Version 1.0
 **/
public interface HouseHoldService {

    /**
     * 查询人口信息
     *
     * @param houseHold 实例对象
     * @return 影响行数
     */
    PageInfo<HouseHold> selectHouseHoldByHouseHoldInfo(
            @Param("houseHold") HouseHold houseHold
            ,@Param("pageNum") int pageNum
            ,@Param("pageSize") int pageSize);


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
    int countByHouseHouseInfo(@Param("houseHold") HouseHold houseHold);

    /**
     * 根据信息统计总行数
     *
     * @param houseParam 查询条件
     * @return 总行数
     */
    List<Integer> selectHouseIdListByHouseParam(HouseParam houseParam);


}

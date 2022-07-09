package com.woniuxy.smart_community.dao;


import com.woniuxy.smart_community.entity.HouseUnit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/8 18:39
 */
public interface HouseUnitDao {

    int insertHouseUnit(@Param("houseUnit") HouseUnit houseUnit);
    int delectHouseUnit(@Param("houseUnit")HouseUnit houseUnit);
    int updateHouseUnit(@Param("houseUnit")HouseUnit houseUnit);
    List<HouseUnit> selectHouseUnit(@Param("houseUnit")HouseUnit houseUnit);
}

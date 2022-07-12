package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author :  Fiver_Hu
 * @Date : 2022/7/9 16:21 星期六
 * @Project_Name -> smart-community
 * @Package_Name -> com.woniuxy.smart_community.entity
 * @ClassName -> HouseInfo
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseInfo {

    private Integer buildingId;
    private Integer unitId;
    private Integer floorId;
    private Integer houseId;
    private Integer housePeopleNums;
    private Integer houseState;
    private String remark;
}
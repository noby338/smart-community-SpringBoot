package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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
    private int houseId;
    private String buildingName;
    private String unitName;
    private String floorName;
    private int housePeopleNums;
    private int houseState;
    private String remark;
}

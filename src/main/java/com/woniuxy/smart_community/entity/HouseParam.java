package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author :  Fiver_Hu
 * @Date : 2022/7/11 16:42 星期一
 * @Project_Name -> smart-community
 * @Package_Name -> com.woniuxy.smart_community.entity
 * @ClassName -> HouseParam
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor

public class HouseParam {

    private Integer buildingId;
    private Integer utilId;
    private Integer floorId;

}

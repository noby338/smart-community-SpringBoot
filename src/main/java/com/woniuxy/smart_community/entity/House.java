package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.woniuxy.smart_community.entity.HouseHold;

import java.util.List;

/**
 * @ClassName -> House
 * @Author Fiver_Hu
 * @Date 2022/7/5 9:34 星期二
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private Integer id;
    private Integer buildingId;
    private Integer unitId;
    private Integer floorId;
    private String houseNum;
    private Integer housePeopleNums;
    private Integer houseState;
    private String remark;
    private PropertyCard propertyCard;//房卡
    private List<HouseHold> houseHoldList;//家庭成员
    private List<Water> waterList;//水费
    private List<Electricity> electricitieList;//电费
    private List<Gas> gasList;//气费
}
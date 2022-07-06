package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer building;
    private Integer unit;
    private Integer floor;
    private String  houseNum;
    private Integer housePeopleNums;
    private Integer houseState;
}

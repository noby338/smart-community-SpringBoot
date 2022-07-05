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
    private int id;
    private int building;
    private int unit;
    private int floor;
    private String house_num;
    private int house_people_nums;
    private int house_state;
}
